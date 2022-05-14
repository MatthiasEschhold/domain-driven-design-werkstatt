package de.novatec.autohaus.werkstatt.werkstattplanung.application.service.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.BearbeiterAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.WerkstattauftragsstatusAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.WerkstattauftragstatusEnum;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command.BearbeiterZuordnenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command.WerkstattauftragPlanenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.factory.TagFactory;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.*;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.*;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag.AktuellenBearbeiterAendern;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag.WerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan.TagesplanBatchCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan.WerkstattplanCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan.WerkstattplanQuery;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.bearbeiter.BearbeiterQuery;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattplan.WerkstattplanDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattplan.WerkstattplanDbQuery;
import de.novatec.autohaus.werkstatt.jmolecules.ApplicationService;
import de.novatec.autohaus.werkstatt.jmolecules.FactoryAsFactoryMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.classical.ApplicationServiceRing;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationServiceRing
@ApplicationService
@Service
@RequiredArgsConstructor
@Slf4j
public class WerkstattplanApplicationService implements WerkstattplanCommand, WerkstattplanQuery, TagesplanBatchCommand {

    private final WerkstattplanDbCommand werkstattplanDbCommand;
    private final WerkstattplanDbQuery werkstattplanDbQuery;
    private final AktuellenBearbeiterAendern aktuellenBearbeiterAendern;
    private final WerkstattauftragCommand werkstattauftragCommand;
    private final BearbeiterQuery bearbeiterQuery;
    private final TagFactory tagFactory;

    @Override
    public Werkstattplan werkstattauftragPlanen(WerkstattauftragPlanenCommand werkstattauftragPlanenCommand) {
        log.trace("Handle command 'Werkstattauftrag planen' with payload: {}", werkstattauftragPlanenCommand);
        try {
            log.trace("Find Werkstattplan with Status 'Aktiv'");
            Werkstattplan werkstattplan = findCurrentWerkstattplan();
            log.trace("Update verfuegbare Bearbeiter in den Tagesplänen mit Status 'Aktiv'");
            bearbeiterAktualisieren(werkstattplan.getTagesplaene());
            werkstattauftragPlanungDurchfuehren(werkstattplan, werkstattauftragPlanenCommand);
            log.trace("Die Terminfindug war erfolgreich und wird persistiert");
            werkstattplanDbCommand.saveWerkstattplan(werkstattplan);
            log.trace("Eventual Consistency durch das Domain Event 'Auftragsstatus auf 'Eingeplant' aktualisiert' durch Aufruf des Command 'Auftragsstatus aktualisieren' im Werkstattauftrag publizieren.");
            werkstattauftragCommand.auftragsstatusAnendern(new WerkstattauftragsstatusAendernCommand(new Werkstattauftragsnummer(werkstattauftragPlanenCommand.getWerkstattauftragRef().getValue()),
                    new Werkstattauftragsstatus(WerkstattauftragstatusEnum.EINGEPLANT.getValue())));
            log.trace("Handle command 'Werkstattauftrag planen' abgearbeitet.");
            return werkstattplan;
        } catch (WerkstattplanFindungException e) {
            throw e;
        } catch (AutomatischeTerminfindungException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    private void bearbeiterAktualisieren(Set<Tagesplan> tagesplaene) {
        tagesplaene.forEach(t -> t.aktualisiereVerfuegbareBearbeiter(bearbeiterQuery.findVerfuegbareWerkstattUndKarrosserieMitarbeiter(t.getTag())));
    }

    private void werkstattauftragPlanungDurchfuehren(Werkstattplan werkstattplan, WerkstattauftragPlanenCommand werkstattauftragPlanenCommand) {
        if (werkstattauftragPlanenCommand.getBearbeiter() != null) {
            log.trace("Der Bearbeiter steht bereits fest. Die Planung wird delegiert an das Aggregate...");
            werkstattplan.werkstattauftragPlanen(werkstattauftragPlanenCommand.getWerkstattauftragRef(),
                    werkstattauftragPlanenCommand.getBearbeiter(),
                    werkstattauftragPlanenCommand.getZeitbedarf());
        } else {
            log.trace("Der Bearbeiter steht noch nicht fest und die Planung wird delegiert an das Aggregate...");
            werkstattplan.werkstattauftragPlanen(werkstattauftragPlanenCommand.getWerkstattauftragRef(),
                    werkstattauftragPlanenCommand.getZeitbedarf());
        }
    }

    @Override
    public Werkstattplan werkstattplanAnlegen() {
        log.trace("Werkstattplan anlegen...");
        Werkstattplan werkstattplan = werkstattplanDbQuery.findAllWerkstattplaeneWithStatus(
                new Werkstattplanstatus(WerkstattplanstatusEnum.AKTIV.getValue())).get(0);
        if (werkstattplan == null) {
            werkstattplan = new Werkstattplan(createTagesplaene());
            werkstattplan = werkstattplanDbCommand.saveWerkstattplan(werkstattplan);
            log.info("Werkstattplan mit Id " + werkstattplan.getWerkstattplanId().getValue() + " angelegt!");
            return werkstattplan;
        }
        throw new WerkstattplanAnlageException("Werkstattplan mit ID " + werkstattplan.getWerkstattplanId().getValue()
                + " befindet sich noch im Status Aktiv und muss erst gelöscht werden");
    }

    @Override
    public void bearbeiterZuordnen(BearbeiterZuordnenCommand bearbeiterZuordnenCommand) {
        log.trace("Bearbeiter {} zu Werkstattauftrag {} zuordnen...", bearbeiterZuordnenCommand.getBearbeiter().getId().getValue(),
                bearbeiterZuordnenCommand.getWerkstattterminId().getValue());
        Werkstattplan werkstattplan = findCurrentWerkstattplan();
        log.trace("Werkstattplan mit Id {} gefunden", werkstattplan.getWerkstattplanId().getValue());
        Werkstatttermin werkstatttermin = werkstattplan.bearbeiterZuordnen(bearbeiterZuordnenCommand.getWerkstattterminId(), bearbeiterZuordnenCommand.getBearbeiter());
        log.trace("Bearbeiter im Werkstattauftrag aktualisieren");
        aktuellenBearbeiterAendern.aktuellenBearbeiterAendern(new BearbeiterAendernCommand(
                new Werkstattauftragsnummer(werkstatttermin.getWerkstattauftragRef().getValue()),
                new BearbeiterRef(bearbeiterZuordnenCommand.getBearbeiter().getId().getValue())));
        log.trace("Zuordnung durchgeführt und Konsistenz zum Werkstattauftrag hergestellt");
    }

    @Override
    public void neuenTagesplanHinzufuegen() {
        Werkstattplan werkstattplan = findCurrentWerkstattplan();
        werkstattplanDbCommand.saveWerkstattplan(werkstattplan);
        Tagesplan tagesplan = werkstattplan.getTagesplaene().stream()
                .sorted(new AktuellesterTagesplanComparator())
                .filter(t -> t.getTagesplanstatus().getValue().equals(TagesplanstatusEnum.AKTIV))
                .findFirst()
                .orElseThrow(() -> new TagesplanFindungException("Tagesplan kann nicht gefunden werden"));
        tagesplan.statusAktualisieren(new Tagesplanstatus(TagesplanstatusEnum.VERGANGEN.getValue()));
        Tag nextTag = tagFactory.createNextDay(tagesplan.getTag());
        Tagesplan nextTagesplan = new Tagesplan(nextTag, bearbeiterQuery.findVerfuegbareWerkstattUndKarrosserieMitarbeiter(nextTag));
        werkstattplan.tagesplanHinzufuegen(nextTagesplan);
        werkstattplanDbCommand.saveWerkstattplan(werkstattplan);
    }

    @Override
    public Werkstattplan leseAktivenWerkstattplan() {
        return findCurrentWerkstattplan();
    }

    private Werkstattplan findCurrentWerkstattplan() {
        Werkstattplan werkstattplan = werkstattplanDbQuery.findAllWerkstattplaeneWithStatus(
                new Werkstattplanstatus(WerkstattplanstatusEnum.AKTIV.getValue())).get(0);
        if (werkstattplan == null) {
            throw new WerkstattplanFindungException("Es kann kein aktiver Werkstattplan ermittelt werden!");
        }
        return werkstattplan;
    }

    @FactoryAsFactoryMethod
    private Set<Tagesplan> createTagesplaene() {
        return tagFactory.createHeutePlus2().stream()
                .map(t -> new Tagesplan(t, bearbeiterQuery.findVerfuegbareWerkstattUndKarrosserieMitarbeiter(t)))
                .collect(Collectors.toSet());
    }
}
