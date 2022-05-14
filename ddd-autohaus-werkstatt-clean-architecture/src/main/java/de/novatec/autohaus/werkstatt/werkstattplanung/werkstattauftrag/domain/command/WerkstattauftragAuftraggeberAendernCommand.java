package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common.BaseWerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.Auftraggeber;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

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
