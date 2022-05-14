package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.event.WerkstattauftragEingeplantDomainEvent;

public interface PublishWerkstattauftragEingeplantEvent {
    void publish(WerkstattauftragEingeplantDomainEvent werkstattauftragEingeplantDomainEvent);
}
