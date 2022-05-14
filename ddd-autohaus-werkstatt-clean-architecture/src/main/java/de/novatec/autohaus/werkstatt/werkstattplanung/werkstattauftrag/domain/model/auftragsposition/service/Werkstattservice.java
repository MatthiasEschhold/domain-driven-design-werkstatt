package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.arbeitswert.kostensatz.Arbeitswert;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.Material;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.MaterialRef;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
public class Werkstattservice {
    private WerkstattserviceBezeichnung bezeichnung;
    private WerkstattserviceRef werkstattserviceRef;
    private Arbeitswert arbeitswert;
    private List<Material> materialien;

    public Werkstattservice(WerkstattserviceBezeichnung bezeichnung, WerkstattserviceRef werkstattserviceRef,
                            Arbeitswert arbeitswertKostensatz, List<Material> materialien) {
        this.bezeichnung = bezeichnung;
        this.werkstattserviceRef = werkstattserviceRef;
        this.arbeitswert = arbeitswertKostensatz;
        this.materialien = materialien;
    }

    public Werkstattservice(WerkstattserviceBezeichnung bezeichnung, WerkstattserviceRef werkstattserviceRef,
                            Arbeitswert arbeitswertKostensatz) {
        this.bezeichnung = bezeichnung;
        this.werkstattserviceRef = werkstattserviceRef;
        this.arbeitswert = arbeitswertKostensatz;
        this.materialien = new ArrayList<>();
    }

    public void addMaterial(Material material) {
        //invarianten prüfen
        this.materialien.add(material);
    }

    public Optional<Material> getMaterial(MaterialRef materialnummer) {
        return this.materialien.stream().filter(m -> m.getMaterialnummer().getValue().equals(materialnummer.getValue())).findFirst();
    }

}
