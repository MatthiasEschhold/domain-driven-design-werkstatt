package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattserviceGruppeBezeichnung {
    private final String value;

    public WerkstattserviceGruppeBezeichnung(String value) {
        this.value = value;
    }
}
