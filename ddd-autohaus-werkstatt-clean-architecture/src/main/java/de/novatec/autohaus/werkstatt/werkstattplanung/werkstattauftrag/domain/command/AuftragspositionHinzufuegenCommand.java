package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.Auftragsposition;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

@Command
@Getter
public class AuftragspositionHinzufuegenCommand extends BaseWerkstattauftragCommand {

    private final Auftragsposition auftragsposition;

    public AuftragspositionHinzufuegenCommand(Werkstattauftragsnummer werkstattauftragsnummer, Auftragsposition auftragsposition) {
        super(werkstattauftragsnummer);
        this.auftragsposition = auftragsposition;
    }
}
