package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Arbeitswert {
    private final Integer value;

    public Arbeitswert(Integer value) {
        this.value = value;
        //check invariant
    }
}
