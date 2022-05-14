package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.jmolecules.OutputPort;

@OutputPort
public interface WerkstattplanDbCommand {
    Werkstattplan saveWerkstattplan(Werkstattplan wekrstattplan);
}
