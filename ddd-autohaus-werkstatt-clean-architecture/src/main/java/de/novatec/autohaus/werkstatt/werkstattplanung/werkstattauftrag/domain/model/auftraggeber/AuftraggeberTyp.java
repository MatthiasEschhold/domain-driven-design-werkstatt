package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Arrays;

@ValueObject
public class AuftraggeberTyp {
    private String value;

    public AuftraggeberTyp(String value) {
        this.value = value;
        Arrays.stream(AuftraggeberTypEnum.values())
                .filter(auftraggeberTypEnum -> value.equals(auftraggeberTypEnum.getValue()))
                .findFirst().orElseThrow(() -> new InvariantException(this.value + " ist nicht im erlaubten Wertebereich vom AuftraggeberTyp"));

    }

    public String getValue() {
        return value;
    }
}
