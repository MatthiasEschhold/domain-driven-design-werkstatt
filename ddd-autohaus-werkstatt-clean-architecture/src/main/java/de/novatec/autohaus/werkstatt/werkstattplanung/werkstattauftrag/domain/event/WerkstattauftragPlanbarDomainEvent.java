package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.event;

import de.novatec.autohaus.werkstatt.jmolecules.DomainEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import lombok.Getter;

@DomainEvent
@Getter
public class WerkstattauftragPlanbarDomainEvent {
    private final Werkstattauftragsnummer auftragsnummer;
    private BearbeiterRef bearbeiterRef;
    private final Zeitbedarf zeitbedarf;

    public WerkstattauftragPlanbarDomainEvent(Werkstattauftragsnummer auftragsnummer, Zeitbedarf zeitbedarf) {
        this.auftragsnummer = auftragsnummer;
        this.zeitbedarf = zeitbedarf;
    }

    public WerkstattauftragPlanbarDomainEvent(Werkstattauftragsnummer auftragsnummer, BearbeiterRef bearbeiterRef, Zeitbedarf zeitbedarf) {
        this.auftragsnummer = auftragsnummer;
        this.bearbeiterRef = bearbeiterRef;
        this.zeitbedarf = zeitbedarf;
    }
}
