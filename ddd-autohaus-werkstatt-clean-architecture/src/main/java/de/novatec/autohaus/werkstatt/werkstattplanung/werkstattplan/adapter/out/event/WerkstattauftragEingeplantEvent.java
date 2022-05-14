package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class WerkstattauftragEingeplantEvent extends ApplicationEvent {

    private final Long werkstattauftragsnummer;

    public WerkstattauftragEingeplantEvent(Object source, Long werkstattauftragsnummer) {
        super(source);
        this.werkstattauftragsnummer = werkstattauftragsnummer;
    }
}
