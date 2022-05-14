package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan;

import de.novatec.autohaus.werkstatt.jmolecules.AllowedDomainValueRange;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
@AllowedDomainValueRange
@Getter
public enum WerkstattplanstatusEnum {
    AKTIV("AKTIV"), ARCHIVIERT("ARCHIVIERT");

    private String value;

    WerkstattplanstatusEnum(String value) {
        this.value = value;
    }

}
