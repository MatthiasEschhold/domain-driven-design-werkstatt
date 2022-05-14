package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class WerkstattauftragsstatusAendernCommand extends BaseWerkstattauftragCommand {

    private final Werkstattauftragsstatus werkstattauftragsstatus;

    public WerkstattauftragsstatusAendernCommand(Werkstattauftragsnummer werkstattauftragsnummer,
                                                 Werkstattauftragsstatus werkstattauftragsstatus) {
        super(werkstattauftragsnummer);
        this.werkstattauftragsstatus = werkstattauftragsstatus;
    }
}
