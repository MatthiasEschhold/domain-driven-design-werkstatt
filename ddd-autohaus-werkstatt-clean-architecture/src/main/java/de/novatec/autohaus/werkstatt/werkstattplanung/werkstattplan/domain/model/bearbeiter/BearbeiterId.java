package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@Getter
@ValueObject
public class BearbeiterId {

    private Long value;

    public BearbeiterId(Long value) {
        this.value = value;
        if (this.value == null) {
            throw new InvariantException("BearbeiterId darf nicht null sein!");
        }
    }
}
