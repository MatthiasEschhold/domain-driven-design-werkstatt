package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource;

import org.springframework.hateoas.RepresentationModel;

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
