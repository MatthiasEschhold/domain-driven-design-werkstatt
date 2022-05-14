package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Materialpreis {
    private final Betrag betrag;
    private final Waehrung waehrung;

    public Materialpreis(Betrag betrag, Waehrung waehrung) {
        this.betrag = betrag;
        this.waehrung = waehrung;
    }
}
