package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.jmolecules.InputPort;

import java.util.List;

@InputPort
public interface WerkstattauftragQuery {
    Werkstattauftrag leseWerkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer);

    List<Werkstattauftrag> leseWerkstattauftraegeWithStatus(Werkstattauftragsstatus werkstattauftragsstatus);

    List<Werkstattauftrag> leseWerkstattauftraegeOfAuftraggeber(AuftraggeberId auftraggeberId);

    List<Werkstattauftrag> findAllWerkstattauftraegeWithStatusBearbeitungsreif();

    List<Werkstattauftrag> leseWerkstattaustraege();

    List<Werkstattauftragsstatus> getAllowedWerkstattauftragstatus();
}
