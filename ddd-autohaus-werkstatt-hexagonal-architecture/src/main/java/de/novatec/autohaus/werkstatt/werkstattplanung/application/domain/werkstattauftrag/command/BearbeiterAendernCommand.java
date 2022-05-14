package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class BearbeiterAendernCommand extends BaseWerkstattauftragCommand {

    private final BearbeiterRef bearbeiterRef;

    public BearbeiterAendernCommand(Werkstattauftragsnummer werkstattauftragsnummer, BearbeiterRef bearbeiterRef) {
        super(werkstattauftragsnummer);
        this.bearbeiterRef = bearbeiterRef;
    }
}
