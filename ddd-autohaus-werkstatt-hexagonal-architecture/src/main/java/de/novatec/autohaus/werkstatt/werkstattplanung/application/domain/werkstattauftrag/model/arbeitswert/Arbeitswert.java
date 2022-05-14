package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.arbeitswert;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.common.Menge;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class Arbeitswert {
    private final Geldwert geldwert;
    private final Zeitwert zeitwert;
    private Waehrung waehrung;
    private Menge menge;

    public Arbeitswert(Geldwert geldwert, Zeitwert zeitwert, Waehrung waehrung, Menge menge) {
        this.geldwert = geldwert;
        this.zeitwert = zeitwert;
        checkIfValueObjectIsNull(this.geldwert, "Geldwert");
        checkIfValueObjectIsNull(this.zeitwert, "Zeitwert");
        checkIfValueObjectIsNullAndSetDefaultMenge(menge);
        checkAndSetDefaultWaehrung(waehrung);
    }

    private void checkAndSetDefaultWaehrung(Waehrung waehrung) {
        if (waehrung == null) {
            waehrung = new Waehrung("EUR");
        }
        this.waehrung = waehrung;
    }

    private void checkIfValueObjectIsNullAndSetDefaultMenge(Menge menge) {
        if (menge == null) {
            menge = new Menge(1.0);
        }
        this.menge = menge;
    }

}
