package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattserviceBezeichnung {
    private final String value;

    public WerkstattserviceBezeichnung(String value) {
        this.value = value;
    }

}
