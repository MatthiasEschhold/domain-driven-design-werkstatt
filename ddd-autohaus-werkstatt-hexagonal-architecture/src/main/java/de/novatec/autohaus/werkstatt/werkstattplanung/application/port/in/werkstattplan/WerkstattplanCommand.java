package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command.BearbeiterZuordnenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command.WerkstattauftragPlanenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.jmolecules.InputPort;

@InputPort
public interface WerkstattplanCommand {
    Werkstattplan werkstattplanAnlegen();

    void bearbeiterZuordnen(BearbeiterZuordnenCommand bearbeiterZuordnenCommand);

    Werkstattplan werkstattauftragPlanen(WerkstattauftragPlanenCommand werkstattauftragPlanenCommand);
}
