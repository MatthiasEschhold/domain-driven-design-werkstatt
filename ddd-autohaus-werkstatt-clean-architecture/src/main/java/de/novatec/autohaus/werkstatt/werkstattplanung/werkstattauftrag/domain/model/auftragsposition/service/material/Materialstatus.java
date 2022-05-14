package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Arrays;
import java.util.Optional;

@ValueObject
@Getter
public class Materialstatus {

    private String value;

    public Materialstatus(String value) {
        this.value = value;
        Optional<MaterialstatusEnum> isAllowedValue = Arrays.stream(MaterialstatusEnum.values()).filter(v -> v.equals(this.value)).findFirst();
        if (isAllowedValue.isEmpty()) {
            throw new InvariantException("Wert " + this.value + " ist nicht im erlaubten Wertebereich!");
        }
    }
}
