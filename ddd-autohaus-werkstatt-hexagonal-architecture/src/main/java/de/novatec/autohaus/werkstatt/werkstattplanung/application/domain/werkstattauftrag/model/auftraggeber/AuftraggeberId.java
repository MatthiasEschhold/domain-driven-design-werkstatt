package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class AuftraggeberId {
    private Long value;

    public AuftraggeberId(Long value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, "AuftraggeberId");
    }

}
