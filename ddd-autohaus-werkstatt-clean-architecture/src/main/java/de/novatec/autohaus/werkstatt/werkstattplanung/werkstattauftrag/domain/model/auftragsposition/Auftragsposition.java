package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.Werkstattservice;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.Material;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.MaterialstatusEnum;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.common.Menge;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

import java.util.Optional;
import java.util.Set;


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
    }

    public Auftragsposition(Auftragspositionnummer auftragspositionsnummer, Werkstattservice werkstattservice, Menge menge) {
        this.auftragspositionsnummer = auftragspositionsnummer;
        this.werkstattservice = werkstattservice;
        this.menge = menge;
    }

    public void addMaterial(Material material) {
        this.werkstattservice.addMaterial(material);
    }

    public void changeMenge(Menge menge) {
        this.menge = menge;
    }

    public void aktualisiereErsatzteile(Set<MaterialRef> materialien, MaterialstatusEnum materialstatusEnum) {
        this.werkstattservice.getMaterialien().stream().forEach(m -> {
            Optional<Material> material = this.werkstattservice.getMaterial(m.getMaterialnummer());
            if (material.isPresent()) {
                material.get().statusAktualisieren(MaterialstatusEnum.VERFUEGBAR);
            } else {
                //Fehlerbehandlung in Abhängigkeit der fachlichen Wünsche implementieren
            }
        });
    }

    public Zeitbedarf ermittleTatsaechlichenZeitbedarf() {
        return new Zeitbedarf(this.werkstattservice.getArbeitswert().getZeitwert().getValue()
                * this.werkstattservice.getArbeitswert().getMenge().getValue());

    }
}
