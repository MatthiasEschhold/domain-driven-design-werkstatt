package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class Vorname {
    private String value;

    public Vorname(String value) {
        this.value = value;
        if (this.value.isBlank()) {
            throw new InvariantException("Vorname darf nicht blank sein");
        }
    }

    public String getValue() {
        return value;
    }
}
