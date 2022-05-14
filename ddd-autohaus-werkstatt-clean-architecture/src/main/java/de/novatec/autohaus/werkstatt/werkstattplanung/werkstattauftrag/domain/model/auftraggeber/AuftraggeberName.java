package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class AuftraggeberName {
    private String value;

    public AuftraggeberName(String value) {
        this.value = value;
        if (this.value == null || this.value.isBlank()) {
            throw new InvariantException("AuftraggeberName darf nicht null oder blank sein!");
        }
    }

    public String getValue() {
        return value;
    }
}
