package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Materialbezeichnung {
    private String value;

    public Materialbezeichnung(String value) {
        this.value = value;
    }
}
