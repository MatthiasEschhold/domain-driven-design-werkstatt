package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model.arbeitswert.kostensatz;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Waehrung {
    private final String value;

    public Waehrung(String value) {
        this.value = value;
    }
}
