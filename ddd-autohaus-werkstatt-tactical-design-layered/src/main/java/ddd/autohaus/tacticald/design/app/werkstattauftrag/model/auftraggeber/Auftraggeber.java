package ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftraggeber;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Auftraggeber {
    private AuftraggeberTypEnum typ;
    private Long id;
    private String name;

    public Auftraggeber(AuftraggeberTypEnum typ, Long id, String name) {
        this.typ = typ;
        this.id = id;
        this.name = name;
    }
}
