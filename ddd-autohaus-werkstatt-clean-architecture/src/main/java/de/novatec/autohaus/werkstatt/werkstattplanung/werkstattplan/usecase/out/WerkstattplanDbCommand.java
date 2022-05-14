package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplan;

public interface WerkstattplanDbCommand {
    Werkstattplan saveWerkstattplan(Werkstattplan wekrstattplan);
}
