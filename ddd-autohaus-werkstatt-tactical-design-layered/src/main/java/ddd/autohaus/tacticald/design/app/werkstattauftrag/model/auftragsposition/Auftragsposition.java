package ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsposition;

import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;


@Entity
@Getter
public class Auftragsposition {
    private final Long auftragspositionsnummer;
    private Werkstattservice werkstattservice;
    private Double menge;

    public Auftragsposition(Long auftragspositionsnummer, Werkstattservice werkstattservice, Double menge) {
        this.auftragspositionsnummer = auftragspositionsnummer;
        this.werkstattservice = werkstattservice;
        this.menge = menge;
    }

    public Auftragsposition(Long auftragspositionsnummer, Werkstattservice werkstattservice) {
        this.auftragspositionsnummer = auftragspositionsnummer;
        this.werkstattservice = werkstattservice;
        this.menge = 0.0;
    }

    public void mengeAendern(Double menge) {
        this.menge = menge;
    }
}
