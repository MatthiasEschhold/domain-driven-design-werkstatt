package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Werkstattplanstatus {
    private final String value;

    public Werkstattplanstatus(String value) {
        this.value = value;
    }
}
