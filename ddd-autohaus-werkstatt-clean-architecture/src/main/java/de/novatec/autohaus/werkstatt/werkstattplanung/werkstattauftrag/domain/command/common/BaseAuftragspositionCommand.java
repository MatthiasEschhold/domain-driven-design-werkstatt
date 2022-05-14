package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.Auftragspositionnummer;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

@Getter
@Command
public abstract class BaseAuftragspositionCommand extends BaseWerkstattauftragCommand {

    private final Auftragspositionnummer auftragspositionnummer;

    public BaseAuftragspositionCommand(Werkstattauftragsnummer auftragnummer, Auftragspositionnummer auftragspositionnummer) {
        super(auftragnummer);
        this.auftragspositionnummer = auftragspositionnummer;
    }
}
