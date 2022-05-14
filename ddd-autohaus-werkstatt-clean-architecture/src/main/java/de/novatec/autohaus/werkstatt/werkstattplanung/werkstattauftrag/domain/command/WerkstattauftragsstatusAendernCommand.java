package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.Werkstattauftragsstatus;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

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
