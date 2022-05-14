package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattserviceRef {
    private Long value;

    public WerkstattserviceRef(Long value) {
        this.value = value;
    }
}
