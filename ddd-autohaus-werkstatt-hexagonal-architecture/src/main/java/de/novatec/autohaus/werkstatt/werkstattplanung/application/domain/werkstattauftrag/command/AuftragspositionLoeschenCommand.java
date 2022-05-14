package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common.BaseAuftragspositionCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.Auftragspositionnummer;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class AuftragspositionLoeschenCommand extends BaseAuftragspositionCommand {

    public AuftragspositionLoeschenCommand(Werkstattauftragsnummer auftragsnummer,
                                           Auftragspositionnummer auftragspositionnummer) {
        super(auftragsnummer, auftragspositionnummer);
    }
}
