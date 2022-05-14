package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattserviceKennung {
    private final String value;

    public WerkstattserviceKennung(String value) {
        this.value = value;
        //check invariant
    }
}
