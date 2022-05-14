package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.Auftragsposition;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class AuftragspositionHinzufuegenCommand extends BaseWerkstattauftragCommand {

    private final Auftragsposition auftragsposition;

    public AuftragspositionHinzufuegenCommand(Werkstattauftragsnummer werkstattauftragsnummer, Auftragsposition auftragsposition) {
        super(werkstattauftragsnummer);
        this.auftragsposition = auftragsposition;
    }
}
