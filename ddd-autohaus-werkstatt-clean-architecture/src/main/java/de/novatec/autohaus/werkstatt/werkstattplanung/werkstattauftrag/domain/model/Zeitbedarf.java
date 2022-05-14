package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@Getter
@ValueObject
public class Zeitbedarf {
    private Double value;

    public Zeitbedarf(Double value) {
        this.value = value;
    }
}
