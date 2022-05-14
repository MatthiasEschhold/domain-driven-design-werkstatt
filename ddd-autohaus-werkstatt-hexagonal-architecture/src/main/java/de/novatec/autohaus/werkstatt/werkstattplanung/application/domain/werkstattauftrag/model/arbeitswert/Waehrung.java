package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.arbeitswert;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Arrays;
import java.util.List;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class Waehrung {
    private final String value;
    private final static List<String> allowedValues = Arrays.asList("EUR, USD");

    public Waehrung(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, "Waehrung");
        if (!allowedValues.contains(this.value)) {
            throw new InvariantException("Die Waehrung ist null oder nicht im erlaubten Wertebereich!");
        }
    }
}
