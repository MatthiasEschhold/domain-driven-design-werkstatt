package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.common;

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
