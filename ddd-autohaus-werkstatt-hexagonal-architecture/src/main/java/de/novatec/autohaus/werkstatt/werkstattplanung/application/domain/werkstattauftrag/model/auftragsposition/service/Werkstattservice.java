package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.arbeitswert.Arbeitswert;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.Material;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.MaterialRef;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

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
        checkIfValueObjectIsNull(this.bezeichnung, "Bezeichnung");
        checkIfValueObjectIsNull(this.werkstattserviceRef, "WerkstattserviceRef");
        checkIfValueObjectIsNull(this.arbeitswert, "Arbeitswert");
        checkIfValueObjectIsNull(this.materialien, "Materialien");
    }

    public Werkstattservice(WerkstattserviceBezeichnung bezeichnung, WerkstattserviceRef werkstattserviceRef,
                            Arbeitswert arbeitswert) {
        this(bezeichnung, werkstattserviceRef, arbeitswert, new ArrayList<>());
    }

    public void addMaterial(Material material) {
        checkIfValueObjectIsNull(material, "Material");
        this.materialien.add(material);
    }

    public Optional<Material> getMaterial(MaterialRef materialnummer) {
        return this.materialien.stream().filter(m -> m.getMaterialnummer().getValue().equals(materialnummer.getValue())).findFirst();
    }

}
