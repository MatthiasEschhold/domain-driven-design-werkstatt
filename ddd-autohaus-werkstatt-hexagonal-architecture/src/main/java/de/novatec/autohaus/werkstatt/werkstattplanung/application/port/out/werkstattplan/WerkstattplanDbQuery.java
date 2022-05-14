package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tagesplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tagesplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattterminId;
import de.novatec.autohaus.werkstatt.jmolecules.OutputPort;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@OutputPort
public interface WerkstattplanDbQuery {
    Optional<Werkstatttermin> findWerkstatttermin(WerkstattterminId werkstattterminId);

    Set<Tagesplan> findAllTagesplaeneWithStatus(Tagesplanstatus tagesplanstatus);

    List<Werkstatttermin> findAllWerkstatttermine();

    List<Werkstattplan> findAllWerkstattplaeneWithStatus(Werkstattplanstatus werkstattplanStatus);
}
