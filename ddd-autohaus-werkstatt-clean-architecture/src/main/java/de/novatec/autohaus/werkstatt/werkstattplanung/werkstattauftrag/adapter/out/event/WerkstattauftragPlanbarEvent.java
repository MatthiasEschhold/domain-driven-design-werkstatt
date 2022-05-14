package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class WerkstattauftragPlanbarEvent extends ApplicationEvent {
    private Long werkstattauftragsnummer;
    private Long bearbeiterRef;
    private double zeitbedarf;

    public WerkstattauftragPlanbarEvent(Object source, Long werkstattauftragsnummer, Double zeitbedarf, Long bearbeiterRef) {
        super(source);
        this.werkstattauftragsnummer = werkstattauftragsnummer;
        this.zeitbedarf = zeitbedarf;
        this.bearbeiterRef = bearbeiterRef;
    }
}
