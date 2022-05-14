package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter;

import lombok.Getter;
import lombok.ToString;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
@ToString
public class Bearbeiter {

    private Name name;
    private Vorname vorname;
    private BearbeiterId id;

    public Bearbeiter(BearbeiterId id, Name name, Vorname vorname) {
        this.name = name;
        this.vorname = vorname;
        this.id = id;
    }

}
