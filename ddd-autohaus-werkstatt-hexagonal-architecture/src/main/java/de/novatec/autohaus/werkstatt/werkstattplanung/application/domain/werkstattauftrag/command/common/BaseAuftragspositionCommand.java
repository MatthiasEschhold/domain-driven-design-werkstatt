package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.Auftragspositionnummer;
import lombok.Getter;

@Getter
public abstract class BaseAuftragspositionCommand extends BaseWerkstattauftragCommand {

    private final Auftragspositionnummer auftragspositionnummer;

    public BaseAuftragspositionCommand(Werkstattauftragsnummer auftragnummer, Auftragspositionnummer auftragspositionnummer) {
        super(auftragnummer);
        this.auftragspositionnummer = auftragspositionnummer;
    }
}
