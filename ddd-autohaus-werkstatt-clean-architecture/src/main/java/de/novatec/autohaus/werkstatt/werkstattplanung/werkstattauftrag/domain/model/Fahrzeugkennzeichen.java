package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@Getter
@ValueObject
public class Fahrzeugkennzeichen {
    private final String value;

    public Fahrzeugkennzeichen(String value) {
        this.value = value;
    }
}
