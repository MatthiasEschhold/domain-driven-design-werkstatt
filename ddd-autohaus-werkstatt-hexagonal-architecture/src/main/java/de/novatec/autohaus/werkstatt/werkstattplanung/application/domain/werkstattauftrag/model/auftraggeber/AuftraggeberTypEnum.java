package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber;

import de.novatec.autohaus.werkstatt.jmolecules.AllowedDomainValueRange;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
@AllowedDomainValueRange
public enum AuftraggeberTypEnum {
    INTERN_NEUWAGEN("INTERN_NEUWAGEN"),
    INTERN_GEBRACHTWAGEN("INTERN_GEBRAUCHTWAGEN"),
    INTERN_WERKSTATT("INTERN_WERKSTATT"),
    INTERN_KAROSSERIE("INTERN_KAROSSERIE"),
    INTERN_LAGER("INTERN_LAGER"),
    KUNDE_PRIVAT("KUNDE_PRIVAT"),
    KUNDE_UNTERNEHMEN("KUNDE_UNTERNEHMEN");

    private String value;

    AuftraggeberTypEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
