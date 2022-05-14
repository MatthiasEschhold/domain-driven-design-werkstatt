package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class Auftraggeber {
    private AuftraggeberTyp typ;
    private AuftraggeberId id;
    private AuftraggeberName name;

    public Auftraggeber(AuftraggeberTyp typ, AuftraggeberId id, AuftraggeberName name) {
        this.typ = typ;
        this.id = id;
        this.name = name;
    }

    public AuftraggeberTyp getTyp() {
        return typ;
    }

    public AuftraggeberId getId() {
        return id;
    }

    public AuftraggeberName getName() {
        return name;
    }
}
