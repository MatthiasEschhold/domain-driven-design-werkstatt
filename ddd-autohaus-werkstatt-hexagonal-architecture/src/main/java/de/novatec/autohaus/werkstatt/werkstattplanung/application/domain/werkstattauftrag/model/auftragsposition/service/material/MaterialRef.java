package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsBlank;
import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class MaterialRef {
    private String value;

    public MaterialRef(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, this.getClass().getSimpleName());
        checkIfValueObjectIsBlank(this.value, this.getClass().getSimpleName());
    }
}
