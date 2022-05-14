package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Materialpreis {
    private final Double value;

    public Materialpreis(Double value) {
        this.value = value;
    }
}
