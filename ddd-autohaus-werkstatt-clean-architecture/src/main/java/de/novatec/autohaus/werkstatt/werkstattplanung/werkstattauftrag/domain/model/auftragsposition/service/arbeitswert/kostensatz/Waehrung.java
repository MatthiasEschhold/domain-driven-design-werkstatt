package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.arbeitswert.kostensatz;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Waehrung {
    private final String value;

    public Waehrung(String value) {
        this.value = value;
    }
}
