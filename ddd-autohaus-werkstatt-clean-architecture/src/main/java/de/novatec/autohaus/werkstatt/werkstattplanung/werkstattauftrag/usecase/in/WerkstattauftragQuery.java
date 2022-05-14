package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in;


import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.Werkstattauftragsstatus;

import java.util.List;

public interface WerkstattauftragQuery {
    Werkstattauftrag leseWerkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer);

    List<Werkstattauftrag> leseWerkstattauftraegeWithStatus(Werkstattauftragsstatus werkstattauftragsstatus);

    List<Werkstattauftrag> leseWerkstattauftraegeOfAuftraggeber(AuftraggeberId auftraggeberId);

    List<Werkstattauftrag> findAllWerkstattauftraegeWithStatusBearbeitungsreif();

    List<Werkstattauftrag> leseWerkstattaustraege();

    List<Werkstattauftragsstatus> getAllowedWerkstattauftragstatus();
}
