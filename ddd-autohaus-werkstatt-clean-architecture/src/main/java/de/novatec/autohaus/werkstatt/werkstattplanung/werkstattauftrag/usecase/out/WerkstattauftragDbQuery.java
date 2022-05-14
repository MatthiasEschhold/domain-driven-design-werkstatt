package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.Werkstattauftragsstatus;

import java.util.List;

public interface WerkstattauftragDbQuery {
    Werkstattauftrag findWerkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer);

    List<Werkstattauftrag> findAllWerkstattauftraegeWithStatus(Werkstattauftragsstatus... werkstattauftragsstatus);

    List<Werkstattauftrag> findWerkstattauftragOfAuftraggeber(AuftraggeberId auftraggeberId);
}
