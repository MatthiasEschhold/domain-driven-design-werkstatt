package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.service;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.BearbeiterAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.AktuellenBearbeiterAendern;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command.BearbeiterZuordnenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command.WerkstattauftragPlanenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.event.WerkstattauftragEingeplantDomainEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.TagFormat;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.*;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in.RolloverTagesplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in.WerkstattplanCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in.WerkstattplanQuery;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.BearbeiterQuery;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.PublishWerkstattauftragEingeplantEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.WerkstattplanDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.WerkstattplanDbQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class WerkstattplanService implements WerkstattplanCommand, WerkstattplanQuery, RolloverTagesplan {

    private final WerkstattplanDbCommand werkstattplanDbCommand;
    private final WerkstattplanDbQuery werkstattplanDbQuery;
    private final AktuellenBearbeiterAendern aktuellenBearbeiterAendern;
    private final BearbeiterQuery bearbeiterQuery;
    private final PublishWerkstattauftragEingeplantEvent publishWerkstattauftragEingeplantEvent;

    @Override
    public Werkstattplan werkstattauftragPlanen(WerkstattauftragPlanenCommand werkstattauftragPlanenCommand) {
        try {
            Werkstattplan werkstattplan = findeAktivenWerkstattplan();
            if (werkstattauftragPlanenCommand.getBearbeiterId() != null) {
                werkstattplan.werkstattauftragPlanen(werkstattauftragPlanenCommand.getWerkstattauftragRef(),
                        bearbeiterQuery.getBearbeiter(werkstattauftragPlanenCommand.getBearbeiterId()),
                        werkstattauftragPlanenCommand.getZeitbedarf());
            } else {
                werkstattplan.werkstattauftragPlanen(werkstattauftragPlanenCommand.getWerkstattauftragRef(),
                        werkstattauftragPlanenCommand.getZeitbedarf());
            }
            werkstattplanDbCommand.saveWerkstattplan(werkstattplan);
            //eventual consistency
            publishWerkstattauftragEingeplantEvent.publish(new WerkstattauftragEingeplantDomainEvent(
                    werkstattauftragPlanenCommand.getWerkstattauftragRef()));

            return werkstattplan;
        } catch (WerkstattplanFindungException e) {
            //@TODO Fehlerbehandlung hinzufügen
            throw e;
        } catch (AutomatischeTerminfindungException e) {
            //@TODO Fehlerbehandlung hinzufügen
            throw e;
        } catch (Exception e) {
            //@TODO Fehlerbehandlung hinzufügen
            throw e;
        }
    }

    @Override
    public void bearbeiterZuordnen(BearbeiterZuordnenCommand bearbeiterZuordnenCommand) {
        Werkstattplan werkstattplan = findeAktivenWerkstattplan();
        Werkstatttermin werkstatttermin = werkstattplan.bearbeiterZuordnen(bearbeiterZuordnenCommand.getWerkstattterminId(), bearbeiterZuordnenCommand.getBearbeiter());
        aktuellenBearbeiterAendern.aktuellenBearbeiterAendern(new BearbeiterAendernCommand(
                new Werkstattauftragsnummer(werkstatttermin.getWerkstattauftragRef().getValue()),
                new BearbeiterRef(bearbeiterZuordnenCommand.getBearbeiter().getId().getValue())));
    }

    @Override
    public void rolloverTagesplan() {
        Werkstattplan werkstattplan = findeAktivenWerkstattplan();
        werkstattplan.rolloverTagesplan();
        werkstattplanDbCommand.saveWerkstattplan(werkstattplan);
    }

    @Override
    public Werkstattplan leseAktivenWerkstattplan() {
        return findeAktivenWerkstattplan();
    }

    private Werkstattplan findeAktivenWerkstattplan() {
        Werkstattplan werkstattplan = werkstattplanDbQuery.findAllWerkstattplaeneWithStatus(new Werkstattplanstatus(WerkstattplanstatusEnum.AKTIV.getValue())).get(0);
        if (werkstattplan == null) {
            throw new WerkstattplanFindungException("Es kann kein aktiver Werkstattplan ermittelt werden!");
        }
        return werkstattplan;
    }

    @Override
    public Werkstattplan werkstattplanAnlegen() {
        Set<Bearbeiter> bearbeiters = bearbeiterQuery.getWerkstattUndKarrosserieMitarbeiter();
        Werkstattplan werkstattplan = new Werkstattplan(createTage(), bearbeiters);
        werkstattplan = werkstattplanDbCommand.saveWerkstattplan(werkstattplan);
        log.info("Werkstattplan mit ID " + werkstattplan.getWerkstattplanId().getValue() + " angelegt!");
        return werkstattplan;
    }

    private Set<Tag> createTage() {
        LocalDate date = LocalDate.now();
        Tag tag1 = new Tag(date.toString(TagFormat.FORMAT()));
        Tag tag2 = new Tag(date.plusDays(1).toString(TagFormat.FORMAT()));
        Tag tag3 = new Tag(date.plusDays(2).toString(TagFormat.FORMAT()));
        Set<Tag> tage = new HashSet<>();
        tage.add(tag1);
        tage.add(tag2);
        tage.add(tag3);
        return tage;
    }

}
