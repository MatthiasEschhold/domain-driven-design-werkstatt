package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.MaterialRef;

import java.util.Set;

public interface AktualisiereMaterialstatus {

    void bestellteMaterialienVerfuegbar(Werkstattauftragsnummer werkstattauftragsnummer,
                                        Set<MaterialRef> ersatzteile);

    void angefragteMaterialenBestellt(Werkstattauftragsnummer werkstattauftragsnummer,
                                      Set<MaterialRef> ersatzteile);
}
