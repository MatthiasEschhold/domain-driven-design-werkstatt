package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsBlank;
import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@ValueObject
@Getter
public class WerkstattserviceBezeichnung {
    private String value;

    public WerkstattserviceBezeichnung(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, this.getClass().getSimpleName());
        checkIfValueObjectIsBlank(this.value, this.getClass().getSimpleName());
    }
}
