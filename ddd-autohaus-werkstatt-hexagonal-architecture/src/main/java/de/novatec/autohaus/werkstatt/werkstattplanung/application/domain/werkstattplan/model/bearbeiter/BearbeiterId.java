package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

@DomainModelRing
@ValueObject
@Getter
public class BearbeiterId {

    private Long value;

    public BearbeiterId(Long value) {
        this.value = value;
        if (this.value == null) {
            throw new InvariantException("BearbeiterId darf nicht null sein!");
        }
    }
}
