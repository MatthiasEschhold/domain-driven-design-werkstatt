package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.event;

import de.novatec.autohaus.werkstatt.jmolecules.DomainEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattauftragRef;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@DomainEvent
@RequiredArgsConstructor
@Getter
public class WerkstattauftragEingeplantDomainEvent {
    private final WerkstattauftragRef werkstattauftragRef;


}
