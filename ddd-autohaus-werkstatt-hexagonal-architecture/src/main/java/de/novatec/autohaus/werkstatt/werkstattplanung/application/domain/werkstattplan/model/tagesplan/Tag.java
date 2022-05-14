package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

@DomainModelRing
@ValueObject
@Getter
public class Tag {
    private String value;

    public Tag(String value) {
        this.value = value;
        if (value == null || !value.matches(TagFormat.value)) {
            throw new InvariantException("Das Format des Tag ist nicht valide oder der Tag ist nicht gesetzt!");
        }
    }

}
