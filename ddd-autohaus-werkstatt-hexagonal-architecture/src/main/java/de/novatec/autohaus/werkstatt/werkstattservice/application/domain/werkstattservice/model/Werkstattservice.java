package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model;

import de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material.Material;
import de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model.arbeitswert.kostensatz.ArbeitswertKostensatz;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.Set;

@AggregateRoot
@Getter
public class Werkstattservice {

    private WerkstattserviceBezeichnung werkstattserviceBezeichnung;
    private WerkstattserviceGruppeRef gruppe;
    private WerkstattserviceKennung werkstattserviceKennung;
    private Set<Material> ersatzteile;
    private Arbeitswert arbeitswert;
    private ArbeitswertKostensatz arbeitswertKostensatz;

    public Werkstattservice(WerkstattserviceBezeichnung werkstattserviceBezeichnung, WerkstattserviceGruppeRef gruppe) {
        this.werkstattserviceBezeichnung = werkstattserviceBezeichnung;
        this.gruppe = gruppe;
    }

    public Werkstattservice(WerkstattserviceBezeichnung werkstattserviceBezeichnung, WerkstattserviceGruppeRef gruppe, WerkstattserviceKennung werkstattserviceKennung) {
        this(werkstattserviceBezeichnung, gruppe);
        this.werkstattserviceKennung = werkstattserviceKennung;
    }

    public void setErsatzteile(Set<Material> ersatzteile) {
        this.ersatzteile = ersatzteile;
    }

    public void setArbeitswert(Arbeitswert arbeitswert) {
        this.arbeitswert = arbeitswert;
    }

    public void setArbeitswertKostensatz(ArbeitswertKostensatz arbeitswertKostensatz) {
        this.arbeitswertKostensatz = arbeitswertKostensatz;
    }
}
