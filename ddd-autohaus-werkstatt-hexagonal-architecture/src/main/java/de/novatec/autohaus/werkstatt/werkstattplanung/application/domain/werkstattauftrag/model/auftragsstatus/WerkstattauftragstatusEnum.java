package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus;

import de.novatec.autohaus.werkstatt.jmolecules.AllowedDomainValueRange;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
@AllowedDomainValueRange
public enum WerkstattauftragstatusEnum {
    ANGELEGT("ANGELEGT"),
    PLANBAR("PLANBAR"),
    GESTARTET("GESTARTET"),
    UNTERBROCHEN("UNTERBROCHEN"),
    FORTGESETZT("FORTGESETZT"),
    STORNIERT("STORNIERT"),
    GESCHLOSSEN("GESCHLOSSEN"),
    EINGEPLANT("EINGEPLANT");

    private String value;

    WerkstattauftragstatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
