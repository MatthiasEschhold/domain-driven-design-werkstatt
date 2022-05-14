package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Menge {
    private Double value;

    public Menge(Double value) {
        this.value = value;
    }
}
