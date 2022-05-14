package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model;

import de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model.arbeitswert.kostensatz.ArbeitswertKostensatz;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class WerkstattserviceGruppe {

    private final WerkstattserviceGruppeBezeichnung bezeichnung;
    private final ArbeitswertKostensatz arbeitswertKostensatz;

    public WerkstattserviceGruppe(WerkstattserviceGruppeBezeichnung bezeichnung, ArbeitswertKostensatz arbeitswertKostensatz) {
        this.bezeichnung = bezeichnung;
        this.arbeitswertKostensatz = arbeitswertKostensatz;
    }
}
