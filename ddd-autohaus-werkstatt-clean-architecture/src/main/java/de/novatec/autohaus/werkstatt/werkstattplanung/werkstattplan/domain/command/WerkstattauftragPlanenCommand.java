package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattauftragRef;
import lombok.Getter;

@Getter
public class WerkstattauftragPlanenCommand {
    private WerkstattauftragRef werkstattauftragRef;
    private BearbeiterId bearbeiterId;
    private Zeitbedarf zeitbedarf;

    public WerkstattauftragPlanenCommand(WerkstattauftragRef werkstattauftragRef, Zeitbedarf zeitbedarf) {
        this.werkstattauftragRef = werkstattauftragRef;
        this.zeitbedarf = zeitbedarf;
    }

    public WerkstattauftragPlanenCommand(WerkstattauftragRef werkstattauftragRef, Zeitbedarf zeitbedarf,
                                         BearbeiterId bearbeiterId) {
        this(werkstattauftragRef, zeitbedarf);
        this.bearbeiterId = bearbeiterId;
    }
}
