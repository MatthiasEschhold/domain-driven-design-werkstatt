package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Werkstattauftragsstatus {
    private final String value;

    public Werkstattauftragsstatus(String value) {
        this.value = value;
    }

}
