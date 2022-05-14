package de.novatec.autohaus.werkstatt.werkstattplanung.application.service.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.WerkstattauftragAuftraggeberAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.WerkstattauftragErstellenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.WerkstattauftragsstatusAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Erstellungsdatum;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.WerkstattauftragstatusEnum;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag.WerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag.WerkstattauftragQuery;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbQuery;
import de.novatec.autohaus.werkstatt.jmolecules.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.classical.ApplicationServiceRing;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationServiceRing
@ApplicationService
@Component
@Slf4j
@RequiredArgsConstructor
public class WerkstattauftragApplicationService implements WerkstattauftragQuery, WerkstattauftragCommand {

    private final WerkstattauftragDbQuery werkstattauftragDbQuery;
    private final WerkstattauftragDbCommand werkstattauftragDbCommand;

    @Override
    public Werkstattauftrag auftragsstatusAnendern(WerkstattauftragsstatusAendernCommand werkstattauftragsstatusAendernCommand) {
        Werkstattauftrag werkstattauftrag = werkstattauftragDbQuery.findWerkstattauftrag(werkstattauftragsstatusAendernCommand.getWerkstattauftragsnummer());
        werkstattauftrag.auftragsstatusAendern(werkstattauftragsstatusAendernCommand.getWerkstattauftragsstatus());
        werkstattauftrag = werkstattauftragDbCommand.save(werkstattauftrag);
        return werkstattauftrag;
    }

    @Override
    public Werkstattauftrag auftraggeberAendern(WerkstattauftragAuftraggeberAendernCommand werkstattauftragAuftraggeberAendernCommand) {
        Werkstattauftrag werkstattauftrag = werkstattauftragDbQuery.findWerkstattauftrag(werkstattauftragAuftraggeberAendernCommand.getWerkstattauftragsnummer());
        werkstattauftrag.auftraggeberAendern(werkstattauftragAuftraggeberAendernCommand.getAuftraggeber());
        werkstattauftrag = werkstattauftragDbCommand.save(werkstattauftrag);
        return werkstattauftrag;
    }

    @Override
    public Werkstattauftrag werkstattauftragErstellen(WerkstattauftragErstellenCommand werkstattauftragErstellenCommand) {
        Werkstattauftrag werkstattauftrag = new Werkstattauftrag(werkstattauftragErstellenCommand.getAuftraggeber(), new Erstellungsdatum(DateTime.now().toString()),
                werkstattauftragErstellenCommand.getFahrzeugkennzeichen());
        if (werkstattauftragErstellenCommand.getBearbeiterId() != null) {
            werkstattauftrag.bearbeiterAendern(werkstattauftragErstellenCommand.getBearbeiterId());
        }
        werkstattauftrag = werkstattauftragDbCommand.save(werkstattauftrag);
        log.info("Werkstattauftrag mit Auftragsnummer {} angelegt.", werkstattauftrag.getWerkstattauftragsnummer().getValue());
        return werkstattauftrag;
    }

    @Override
    public Werkstattauftrag leseWerkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer) {
        return werkstattauftragDbQuery.findWerkstattauftrag(werkstattauftragsnummer);
    }

    @Override
    public List<Werkstattauftrag> leseWerkstattauftraegeWithStatus(Werkstattauftragsstatus werkstattauftragsstatus) {
        return werkstattauftragDbQuery.findAllWerkstattauftraegeWithStatus(werkstattauftragsstatus);
    }

    @Override
    public List<Werkstattauftrag> leseWerkstattauftraegeOfAuftraggeber(AuftraggeberId auftraggeberId) {
        return werkstattauftragDbQuery.findWerkstattauftragOfAuftraggeber(auftraggeberId);
    }

    @Override
    public List<Werkstattauftrag> findAllWerkstattauftraegeWithStatusBearbeitungsreif() {
        return werkstattauftragDbQuery.findAllWerkstattauftraegeWithStatus(
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.PLANBAR.getValue()));
    }

    @Override
    public List<Werkstattauftrag> leseWerkstattaustraege() {
        return werkstattauftragDbQuery.findAllWerkstattauftraegeWithStatus(
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.PLANBAR.getValue()),
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.ANGELEGT.getValue()),
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.GESTARTET.getValue()),
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.FORTGESETZT.getValue()),
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.UNTERBROCHEN.getValue()));
    }

    @Override
    public List<Werkstattauftragsstatus> getAllowedWerkstattauftragstatus() {
        return Arrays.stream(WerkstattauftragstatusEnum.values()).map(e -> new Werkstattauftragsstatus(e.getValue())).collect(Collectors.toList());
    }

}
