package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Fahrzeugkennzeichen;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.Auftraggeber;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

@Command
@Getter
public class WerkstattauftragErstellenCommand {
    private final Auftraggeber auftraggeber;
    private BearbeiterRef bearbeiterId;
    private Fahrzeugkennzeichen fahrzeugkennzeichen;

    public WerkstattauftragErstellenCommand(Auftraggeber auftraggeber, Fahrzeugkennzeichen fahrzeugkennzeichen) {
        this.auftraggeber = auftraggeber;
        this.fahrzeugkennzeichen = fahrzeugkennzeichen;
    }

    public void setBearbeiterId(BearbeiterRef bearbeiterId) {
        this.bearbeiterId = bearbeiterId;
    }
}
