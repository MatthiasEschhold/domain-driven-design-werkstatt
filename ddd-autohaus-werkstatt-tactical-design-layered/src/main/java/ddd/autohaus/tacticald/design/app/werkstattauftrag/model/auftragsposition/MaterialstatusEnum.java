package ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsposition;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public enum MaterialstatusEnum {
    BESTELLT("BESTELLT"), VERBUCHT("VERBUCHT"), VERFUEGBAR("VERFUEGBAR");

    private String value;

    MaterialstatusEnum(String value) {
        this.value = value;
    }
}
