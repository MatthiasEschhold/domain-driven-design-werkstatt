package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.Werkstattservice;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.Material;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.MaterialstatusEnum;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.common.Menge;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.Entity;

import java.util.Optional;
import java.util.Set;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@Entity
@Getter
public class Auftragsposition {
    private final Auftragspositionnummer auftragspositionsnummer;
    private Werkstattservice werkstattservice;
    private Menge menge;

    public Auftragsposition(Auftragspositionnummer auftragspositionsnummer, Werkstattservice werkstattservice) {
        this.auftragspositionsnummer = auftragspositionsnummer;
        this.werkstattservice = werkstattservice;
        this.menge = new Menge(1.0);
        checkIfValueObjectIsNull(this.auftragspositionsnummer, "Auftragspositionsummer");
        checkIfValueObjectIsNull(this.werkstattservice, "Werkstattservice");
    }

    public Auftragsposition(Auftragspositionnummer auftragspositionsnummer, Werkstattservice werkstattservice, Menge menge) {
        this(auftragspositionsnummer, werkstattservice);
        this.menge = menge;
        checkIfValueObjectIsNull(this.menge, "Menge");
    }

    public void addMaterial(Material material) {
        checkIfValueObjectIsNull(material, "Material");
        this.werkstattservice.addMaterial(material);
    }

    public void changeMenge(Menge menge) {
        checkIfValueObjectIsNull(menge, "Menge");
        this.menge = menge;
    }

    public void aktualisiereErsatzteile(Set<MaterialRef> materialien, MaterialstatusEnum materialstatusEnum) {
        checkIfValueObjectIsNull(materialien, "Materialien");
        checkIfValueObjectIsNull(materialstatusEnum, "Materialstatus");
        this.werkstattservice.getMaterialien().stream().forEach(m -> {
            Optional<Material> material = this.werkstattservice.getMaterial(m.getMaterialnummer());
            if (material.isPresent()) {
                material.get().statusAktualisieren(MaterialstatusEnum.VERFUEGBAR);
            }
        });
    }
}
