package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Waehrung {
    private final String value;

    public Waehrung(String value) {
        this.value = value;
        //check invariante
    }
}
