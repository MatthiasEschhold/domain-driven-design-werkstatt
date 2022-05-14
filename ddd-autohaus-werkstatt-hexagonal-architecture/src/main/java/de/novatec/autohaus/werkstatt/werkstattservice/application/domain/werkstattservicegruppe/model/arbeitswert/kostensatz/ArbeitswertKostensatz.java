package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model.arbeitswert.kostensatz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.ddd.annotation.Entity;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class ArbeitswertKostensatz {
    private Kostensatz kostensatz;
    private Waehrung waehrung;
    private Abrechnungseinheit abrechnungseinheit;
}
