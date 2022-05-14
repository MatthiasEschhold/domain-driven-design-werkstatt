package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.jmolecules.OutputPort;

import java.util.List;

@OutputPort
public interface WerkstattauftragDbQuery {
    Werkstattauftrag findWerkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer);

    List<Werkstattauftrag> findAllWerkstattauftraegeWithStatus(Werkstattauftragsstatus... werkstattauftragsstatus);

    List<Werkstattauftrag> findWerkstattauftragOfAuftraggeber(AuftraggeberId auftraggeberId);
}
