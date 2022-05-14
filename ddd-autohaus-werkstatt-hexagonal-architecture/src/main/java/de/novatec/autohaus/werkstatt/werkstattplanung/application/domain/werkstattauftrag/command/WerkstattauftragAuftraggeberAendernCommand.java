package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.Auftraggeber;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class WerkstattauftragAuftraggeberAendernCommand extends BaseWerkstattauftragCommand {

    private final Auftraggeber auftraggeber;

    public WerkstattauftragAuftraggeberAendernCommand(Werkstattauftragsnummer werkstattauftragsnummer,
                                                      Auftraggeber auftraggeber) {
        super(werkstattauftragsnummer);
        this.auftraggeber = auftraggeber;
    }
}
