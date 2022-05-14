package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class Erstellungsdatum {
    private String value;

    public Erstellungsdatum(String value) {
        this.value = value;
        //check invariante
    }

    public String getValue() {
        return value;
    }
}
