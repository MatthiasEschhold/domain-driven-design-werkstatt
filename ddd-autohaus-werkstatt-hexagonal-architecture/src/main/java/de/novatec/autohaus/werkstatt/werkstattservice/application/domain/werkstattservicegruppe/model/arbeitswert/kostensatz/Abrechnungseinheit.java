package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model.arbeitswert.kostensatz;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Arrays;

@ValueObject
@Getter
public class Abrechnungseinheit {
    private String value;

    public Abrechnungseinheit(String value) {
        this.value = value;
        Arrays.stream(AbrechnungseinheitEnum.values())
                .filter(abrechnungseinheitEnum -> value.equals(abrechnungseinheitEnum.getValue()))
                .findFirst().orElseThrow(() -> new InvariantException(this.value + " ist nicht im erlaubten Wertebereich der Abrechnungseinheit"));

    }
}
