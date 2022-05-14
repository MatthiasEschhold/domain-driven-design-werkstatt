package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import org.jmolecules.ddd.annotation.ValueObject;

/**
 * Kann eine KundenId sein, wenn AuftraggeberTyp KUNDE_PRIVAT oder KUNDE_UNTERNEHMEN
 * Kann eine MitarbeiterId sein, wenn Auftraggeber INTERN ist
 */

@ValueObject
public class AuftraggeberId {
    private Long value;

    public AuftraggeberId(Long value) {
        this.value = value;
        if (this.value == null) {
            throw new InvariantException("AuftraggeberId darf nicht null sein");
        }
    }

    public Long getValue() {
        return value;
    }
}
