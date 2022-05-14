package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattterminId;
import lombok.Getter;

@Getter
public class BearbeiterZuordnenCommand {
    private WerkstattterminId werkstattterminId;
    private Bearbeiter bearbeiter;

    public BearbeiterZuordnenCommand(WerkstattterminId werkstattterminId, Bearbeiter bearbeiter) {
        this.werkstattterminId = werkstattterminId;
        this.bearbeiter = bearbeiter;
    }
}
