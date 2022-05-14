package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.jmolecules.InputPort;

@InputPort
public interface WerkstattplanQuery {
    Werkstattplan leseAktivenWerkstattplan();
}
