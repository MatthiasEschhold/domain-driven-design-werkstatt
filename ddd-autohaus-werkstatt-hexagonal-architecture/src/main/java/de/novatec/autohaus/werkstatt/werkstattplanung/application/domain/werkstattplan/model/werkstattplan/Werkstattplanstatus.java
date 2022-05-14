package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

@DomainModelRing
@ValueObject
@Getter
public class Werkstattplanstatus {
    private final String value;

    public Werkstattplanstatus(String value) {
        this.value = value;
    }
}
