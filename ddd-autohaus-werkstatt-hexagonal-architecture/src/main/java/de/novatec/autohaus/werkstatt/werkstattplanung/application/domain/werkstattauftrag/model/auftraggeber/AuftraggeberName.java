package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsBlank;
import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class AuftraggeberName {
    private String value;

    public AuftraggeberName(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, this.getClass().getSimpleName());
        checkIfValueObjectIsBlank(this.value, this.getClass().getSimpleName());
    }

}
