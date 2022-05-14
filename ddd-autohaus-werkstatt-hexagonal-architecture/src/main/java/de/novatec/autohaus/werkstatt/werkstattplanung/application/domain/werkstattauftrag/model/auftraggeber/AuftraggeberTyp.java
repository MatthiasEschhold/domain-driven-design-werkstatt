package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Arrays;
import java.util.stream.Collectors;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.*;

@DomainModelRing
@ValueObject
@Getter
public class AuftraggeberTyp {
    private String value;

    public AuftraggeberTyp(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, this.getClass().getSimpleName());
        checkIfValueObjectIsBlank(this.value, this.getClass().getSimpleName());
        checkIfValueObjectIsInAllowedValueRange(this.value, Arrays.stream(AuftraggeberTypEnum.values())
                .map(e -> e.getValue()).collect(Collectors.toList()), this.getClass().getSimpleName());

    }

}
