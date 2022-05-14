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
public class Zeitwert {
    private final Double value;
    private final static List<Double> allowedValues = Arrays.asList(15.0);

    public Zeitwert(Double value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, "Zeitwert");
        if (!allowedValues.contains(value)) {
            throw new InvariantException("Der Zeitwert ist null oder nicht im erlaubten Wertebereich");
        }
    }
}

