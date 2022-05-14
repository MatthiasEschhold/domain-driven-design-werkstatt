package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Arrays;
import java.util.stream.Collectors;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.*;

@DomainModelRing
@ValueObject
@Getter
public class Materialstatus {

    private String value;

    public Materialstatus(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, this.getClass().getSimpleName());
        checkIfValueObjectIsBlank(this.value, this.getClass().getSimpleName());
        checkIfValueObjectIsInAllowedValueRange(this.value,
                Arrays.stream(MaterialstatusEnum.values()).map(e -> e.getValue()).collect(Collectors.toList()), this.getClass().getSimpleName());
    }
}
