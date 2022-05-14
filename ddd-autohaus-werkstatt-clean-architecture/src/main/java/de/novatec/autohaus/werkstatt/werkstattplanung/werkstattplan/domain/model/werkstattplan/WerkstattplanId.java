package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattplanId {
    private Long value;

    public WerkstattplanId(Long value) {
        this.value = value;
    }
}
