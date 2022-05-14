package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Tagesplanstatus {
    private final String value;

    public Tagesplanstatus(String value) {
        this.value = value;
    }
}
