package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattserviceBezeichnung {
    private String value;

    public WerkstattserviceBezeichnung(String value) {
        this.value = value;
        //check invariant
    }
}
