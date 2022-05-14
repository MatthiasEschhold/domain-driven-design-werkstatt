package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Materialeinheit {
    private final String value;

    public Materialeinheit(String value) {
        this.value = value;
    }
}
