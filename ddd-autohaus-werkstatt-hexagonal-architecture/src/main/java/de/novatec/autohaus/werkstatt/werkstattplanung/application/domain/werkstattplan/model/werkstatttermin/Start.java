package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

@DomainModelRing
@ValueObject
@Getter
public class Start {
    private final String value;

    public Start(String value) {
        this.value = value;
        if (value == null || !value.matches(TerminStartEndeFormat.value)) {
            throw new InvariantException("Das Format des Tag ist nicht valide oder der Tag ist nicht gesetzt!");
        }
    }

}
