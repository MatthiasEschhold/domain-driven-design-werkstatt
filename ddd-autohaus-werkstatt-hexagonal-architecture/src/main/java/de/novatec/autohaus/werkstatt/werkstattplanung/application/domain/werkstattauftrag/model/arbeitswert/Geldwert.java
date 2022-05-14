package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.arbeitswert;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class Geldwert {
    private final Double value;

    public Geldwert(Double value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, "Geldwert");
        if (this.value <= 0) {
            throw new InvariantException("Der Geldwert kann nicht null oder negativ sein!");
        }
    }
}
