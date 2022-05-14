package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.event;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag.AktualisiereMaterialstatus;
import de.novatec.autohaus.werkstatt.jmolecules.EventListener;
import de.novatec.autohaus.werkstatt.jmolecules.InputAdapter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import java.util.HashSet;
import java.util.Set;

@InfrastructureRing
@InputAdapter
@EventListener
@RequiredArgsConstructor
public class OriginalteileVerfuegbarEventListener {

    private final AktualisiereMaterialstatus aktualisiereMaterialstatus;

    public void onErsatzteileVerfuegbarEvent(String payload) {
        aktualisiereMaterialstatus.bestellteMaterialienVerfuegbar(
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
