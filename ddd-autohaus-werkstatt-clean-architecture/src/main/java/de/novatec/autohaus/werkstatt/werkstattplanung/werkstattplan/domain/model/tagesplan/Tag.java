package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Tag {
    private String value;

    public Tag(String value) {
        this.value = value;
        if (value == null || value.matches(TagFormat.value)) {
            throw new InvariantException("Das Format des Tag ist nicht valide oder der Tag ist nicht gesetzt!");
        }
    }

}
