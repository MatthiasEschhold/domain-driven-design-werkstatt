package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattauftrag.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.hateoas.RepresentationModel;

@InfrastructureRing
@Resource
public class AuftragspositionResource extends RepresentationModel<AuftragspositionResource> {

    private String auftragspositionsnummer;
    private String auftragspositionTyp;
    private double menge;

    public String getAuftragspositionsnummer() {
        return auftragspositionsnummer;
    }

    public void setAuftragspositionsnummer(String auftragspositionsnummer) {
        this.auftragspositionsnummer = auftragspositionsnummer;
    }

    public String getAuftragspositionTyp() {
        return auftragspositionTyp;
    }

    public void setAuftragspositionTyp(String auftragspositionTyp) {
        this.auftragspositionTyp = auftragspositionTyp;
    }

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }
}
