package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.event;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.event.WerkstattauftragPlanbarDomainEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.PublishWerkstattauftragPlanbarEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WerkstattauftragPlanbarEventPublisher implements PublishWerkstattauftragPlanbarEvent {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(WerkstattauftragPlanbarDomainEvent domainEvent) {
        applicationEventPublisher.publishEvent(
                new WerkstattauftragPlanbarEvent(this, domainEvent.getAuftragsnummer().getValue(), domainEvent.getZeitbedarf().getValue(),
                        domainEvent.getBearbeiterRef().getValue()));
    }
}
