package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out;


import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.event.WerkstattauftragPlanbarDomainEvent;

public interface PublishWerkstattauftragPlanbarEvent {
    void publish(WerkstattauftragPlanbarDomainEvent werkstattauftragPlanbarDomainEvent);
}
