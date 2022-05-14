package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Ende {
    private final String value;

    public Ende(String value) {
        this.value = value;
        if (value == null || value.matches(TerminStartEndeFormat.value)) {
            throw new InvariantException("Das Format des Tag ist nicht valide oder der Tag ist nicht gesetzt!");
        }
    }
}
