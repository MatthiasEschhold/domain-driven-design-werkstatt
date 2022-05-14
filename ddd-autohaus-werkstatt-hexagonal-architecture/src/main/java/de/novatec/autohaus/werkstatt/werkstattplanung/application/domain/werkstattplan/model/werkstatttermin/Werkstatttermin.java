package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.Entity;

@DomainModelRing
@Entity
@Getter
public class Werkstatttermin {
    private WerkstattterminId terminId;
    private final WerkstattauftragRef werkstattauftragRef;
    private Bearbeiter bearbeiter;
    private Start start;
    private Ende ende;

    public Werkstatttermin(WerkstattauftragRef werkstattauftragRef, Bearbeiter bearbeiter, Start start, Ende ende) {
        this.werkstattauftragRef = werkstattauftragRef;
        this.bearbeiter = bearbeiter;
        this.start = start;
        this.ende = ende;
    }

    public Werkstatttermin(WerkstattterminId terminId, WerkstattauftragRef werkstattauftragRef, Bearbeiter bearbeiter, Start start, Ende ende) {
        this(werkstattauftragRef, bearbeiter, start, ende);
        this.terminId = terminId;
    }

    public void bearbeiterZuordnen(Bearbeiter bearbeiter) {
        this.bearbeiter = bearbeiter;
    }
}
