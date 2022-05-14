package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

@DomainModelRing
@ValueObject
@Getter
public class Erstellungsdatum {
    private String value;

    public Erstellungsdatum(String value) {
        this.value = value;
    }
}
