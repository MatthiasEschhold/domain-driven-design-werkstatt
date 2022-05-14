package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattserviceGruppeRef {
    private String value;

    public WerkstattserviceGruppeRef(String value) {
        this.value = value;
    }
}
