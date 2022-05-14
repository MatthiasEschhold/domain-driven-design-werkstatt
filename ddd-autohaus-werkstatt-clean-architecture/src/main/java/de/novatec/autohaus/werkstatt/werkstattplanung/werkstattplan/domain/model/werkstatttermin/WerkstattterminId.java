package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattterminId {
    private Long value;

    public WerkstattterminId(Long value) {
        this.value = value;
    }
}
