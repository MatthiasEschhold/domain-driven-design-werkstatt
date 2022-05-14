package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Fahrzeugkennzeichen;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.Auftraggeber;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
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
