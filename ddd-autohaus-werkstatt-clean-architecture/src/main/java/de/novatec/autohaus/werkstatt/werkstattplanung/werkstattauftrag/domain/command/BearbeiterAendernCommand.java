package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

@Command
@Getter
public class BearbeiterAendernCommand extends BaseWerkstattauftragCommand {

    private final BearbeiterRef bearbeiterRef;

    public BearbeiterAendernCommand(Werkstattauftragsnummer werkstattauftragsnummer, BearbeiterRef bearbeiterRef) {
        super(werkstattauftragsnummer);
        this.bearbeiterRef = bearbeiterRef;
    }
}
