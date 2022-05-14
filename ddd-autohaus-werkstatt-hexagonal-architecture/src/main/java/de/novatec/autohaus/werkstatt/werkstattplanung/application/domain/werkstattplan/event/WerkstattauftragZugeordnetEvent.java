package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.event;

import de.novatec.autohaus.werkstatt.jmolecules.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@DomainEvent
@Getter
@AllArgsConstructor
public class WerkstattauftragZugeordnetEvent {
    private Long bearbeiterId;
}
