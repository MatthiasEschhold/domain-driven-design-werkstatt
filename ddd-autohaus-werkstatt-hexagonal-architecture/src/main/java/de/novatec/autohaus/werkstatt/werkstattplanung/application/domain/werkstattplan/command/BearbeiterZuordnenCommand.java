package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattterminId;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class BearbeiterZuordnenCommand {
    private WerkstattterminId werkstattterminId;
    private Bearbeiter bearbeiter;

    public BearbeiterZuordnenCommand(WerkstattterminId werkstattterminId, Bearbeiter bearbeiter) {
        this.werkstattterminId = werkstattterminId;
        this.bearbeiter = bearbeiter;
    }
}
