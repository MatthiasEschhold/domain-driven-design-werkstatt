package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.jmolecules.InputPort;

import java.util.Set;

@InputPort
public interface AktualisiereMaterialstatus {
    void bestellteMaterialienVerfuegbar(Werkstattauftragsnummer werkstattauftragsnummer, Set<MaterialRef> ersatzteile);
}
