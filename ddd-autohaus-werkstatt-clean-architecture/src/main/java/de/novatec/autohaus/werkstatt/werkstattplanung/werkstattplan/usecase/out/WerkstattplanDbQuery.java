package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tagesplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tagesplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattterminId;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WerkstattplanDbQuery {
    Optional<Werkstatttermin> findWerkstatttermin(WerkstattterminId werkstattterminId);

    Set<Tagesplan> findAllTagesplaeneWithStatus(Tagesplanstatus tagesplanstatus);

    List<Werkstatttermin> findAllWerkstatttermine();

    List<Werkstattplan> findAllWerkstattplaeneWithStatus(Werkstattplanstatus werkstattplanStatus);
}
