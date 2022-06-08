package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.event;

import de.novatec.autohaus.werkstatt.jmolecules.DomainEventListener;
import de.novatec.autohaus.werkstatt.jmolecules.InputAdapter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.AktualisiereMaterialstatus;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@InputAdapter
@DomainEventListener
@RequiredArgsConstructor
public class OriginalteileVerfuegbarEventListener {

    private final AktualisiereMaterialstatus aktualisiereMaterialstatus;

    public void onErsatzteileVerfuegbarEvent(String payload) {
        aktualisiereMaterialstatus.bestellteMaterialienVerfuegbar(
                extractWerkstattauftragsnummer(payload),
                extractMaterialnummers(payload));
    }

    public void onErsatzteileBestelltEvent(String payload) {
        aktualisiereMaterialstatus.angefragteMaterialenBestellt(
                extractWerkstattauftragsnummer(payload),
                extractMaterialnummers(payload));
    }

    private Werkstattauftragsnummer extractWerkstattauftragsnummer(String payload) {
        return new Werkstattauftragsnummer(1L);
    }

    private Set<MaterialRef> extractMaterialnummers(String payload) {
        Set<MaterialRef> materialnummern = new HashSet<>();
        //Originalteilenummer aus payload extrahieren
        materialnummern.add(new MaterialRef("12345tz78"));
        return materialnummern;
    }
}
