package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.arbeitswert.kostensatz;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Zeitwert {
    private final Double value;

    public Zeitwert(Double value) {
        this.value = value;
    }
}
