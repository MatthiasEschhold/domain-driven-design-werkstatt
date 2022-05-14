package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class MaterialRef {
    private String value;

    public MaterialRef(String value) {
        this.value = value;
    }
}
