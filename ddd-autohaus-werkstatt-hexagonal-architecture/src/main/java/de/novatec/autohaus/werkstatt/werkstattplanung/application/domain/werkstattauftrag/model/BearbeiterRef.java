package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Objects;

@DomainModelRing
@ValueObject
@Getter
public class BearbeiterRef {

    private Long value;

    public BearbeiterRef(Long value) {
        this.value = value;
        if (this.value == null) {
            throw new InvariantException("BearbeiterId darf nicht null sein!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BearbeiterRef that = (BearbeiterRef) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
