package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common.BaseAuftragspositionCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.Auftragspositionnummer;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

@Command
@Getter
public class AuftragspositionLoeschenCommand extends BaseAuftragspositionCommand {

    public AuftragspositionLoeschenCommand(Werkstattauftragsnummer auftragsnummer,
                                           Auftragspositionnummer auftragspositionnummer) {
        super(auftragsnummer, auftragspositionnummer);
    }
}
