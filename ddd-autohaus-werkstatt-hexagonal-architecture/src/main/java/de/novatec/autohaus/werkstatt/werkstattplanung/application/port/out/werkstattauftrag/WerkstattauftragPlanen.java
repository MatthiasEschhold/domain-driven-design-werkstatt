package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattauftragRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.jmolecules.OutputPort;

@OutputPort
public interface WerkstattauftragPlanen {
    Werkstatttermin werkstattauftragPlanen(WerkstattauftragRef werkstattauftragRef);
}
