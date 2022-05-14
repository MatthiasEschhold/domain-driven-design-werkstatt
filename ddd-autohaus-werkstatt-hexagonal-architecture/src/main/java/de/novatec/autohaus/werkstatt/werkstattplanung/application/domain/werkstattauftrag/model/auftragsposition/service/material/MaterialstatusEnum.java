package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material;

import de.novatec.autohaus.werkstatt.jmolecules.AllowedDomainValueRange;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
@AllowedDomainValueRange
@Getter
public enum MaterialstatusEnum {
    BESTELLT("BESTELLT"), VERBUCHT("VERBUCHT"), VERFUEGBAR("VERFUEGBAR");

    private String value;

    MaterialstatusEnum(String value) {
        this.value = value;
    }
}
