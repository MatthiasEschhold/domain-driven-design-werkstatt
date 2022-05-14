package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattauftragRef;
import lombok.Getter;
import lombok.ToString;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
@ToString
public class WerkstattauftragPlanenCommand {
    private WerkstattauftragRef werkstattauftragRef;
    private Double zeitbedarf;
    private Bearbeiter bearbeiter;

    public WerkstattauftragPlanenCommand(WerkstattauftragRef werkstattauftragRef, Double zeitbedarf) {
        this.werkstattauftragRef = werkstattauftragRef;
        this.zeitbedarf = zeitbedarf;
    }

    public WerkstattauftragPlanenCommand(WerkstattauftragRef werkstattauftragRef, Double zeitbedarf,
                                         Bearbeiter bearbeiter) {
        this(werkstattauftragRef, zeitbedarf);
        this.bearbeiter = bearbeiter;
    }
}
