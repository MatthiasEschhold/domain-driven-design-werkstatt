package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsBlank;
import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class Materialbezeichnung {
    private String value;

    public Materialbezeichnung(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, "AuftraggeberName");
        checkIfValueObjectIsBlank(this.value, "AuftraggeberName");
    }
}
