package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class Name {
    private String value;

    public Name(String value) {
        this.value = value;
        if (this.value.isBlank()) {
            throw new InvariantException("Name darf nicht blank sein");
        }
    }

    public String getValue() {
        return value;
    }
}
