package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.event;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.event.WerkstattauftragEingeplantDomainEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.PublishWerkstattauftragEingeplantEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WerkstattauftragEingeplantEventPublisher implements PublishWerkstattauftragEingeplantEvent {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(WerkstattauftragEingeplantDomainEvent werkstattauftragEingeplantDomainEvent) {
        throw new UnsupportedOperationException("coming soon...");
    }
}
