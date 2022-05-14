package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;

public interface WerkstattauftragDbCommand {
    Werkstattauftrag save(Werkstattauftrag werkstattauftrag);

    void archivieren(Werkstattauftragsnummer werkstattauftragsnummer);

    void aktualisiereBearbeiter(Werkstattauftragsnummer werkstattauftragsnummer, BearbeiterId bearbeiterId);

    void updateWerkstattauftragsstatus(Werkstattauftragsnummer werkstattauftragsnummer, Werkstattauftragsstatus werkstattauftragsstatus);
}
