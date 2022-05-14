package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material;

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
