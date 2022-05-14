package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.jmolecules.OutputPort;

@OutputPort
public interface WerkstattauftragDbCommand {
    Werkstattauftrag save(Werkstattauftrag werkstattauftrag);

    void archivieren(Werkstattauftragsnummer werkstattauftragsnummer);

    void aktualisiereBearbeiter(Werkstattauftragsnummer werkstattauftragsnummer, BearbeiterId bearbeiterId);

    void updateWerkstattauftragsstatus(Werkstattauftragsnummer werkstattauftragsnummer, Werkstattauftragsstatus werkstattauftragsstatus);
}
