package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
@RequiredArgsConstructor
public class Material {
    private final Materialbezeichnung bezeichnung;
    private final MaterialRef materialnummer;
    private final Materialeinheit einheit;
    private final Materialpreis preis;
}
