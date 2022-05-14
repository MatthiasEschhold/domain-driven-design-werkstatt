package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material;

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
