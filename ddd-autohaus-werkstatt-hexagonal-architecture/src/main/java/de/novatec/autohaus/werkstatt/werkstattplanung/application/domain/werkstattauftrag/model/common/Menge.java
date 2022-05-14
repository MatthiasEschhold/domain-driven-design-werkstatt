package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.common;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

@DomainModelRing
@ValueObject
@Getter
public class Menge {
    private Double value;

    public Menge(Double value) {
        this.value = value;
    }
}
