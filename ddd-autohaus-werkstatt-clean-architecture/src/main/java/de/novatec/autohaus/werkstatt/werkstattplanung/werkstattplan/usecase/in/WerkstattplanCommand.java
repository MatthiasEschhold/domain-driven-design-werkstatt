package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command.BearbeiterZuordnenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command.WerkstattauftragPlanenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplan;

public interface WerkstattplanCommand {
    Werkstattplan werkstattplanAnlegen();

    void bearbeiterZuordnen(BearbeiterZuordnenCommand bearbeiterZuordnenCommand);

    Werkstattplan werkstattauftragPlanen(WerkstattauftragPlanenCommand werkstattauftragPlanenCommand);
}
