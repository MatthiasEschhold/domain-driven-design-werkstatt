package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplan;

public interface WerkstattplanQuery {
    Werkstattplan leseAktivenWerkstattplan();
}
