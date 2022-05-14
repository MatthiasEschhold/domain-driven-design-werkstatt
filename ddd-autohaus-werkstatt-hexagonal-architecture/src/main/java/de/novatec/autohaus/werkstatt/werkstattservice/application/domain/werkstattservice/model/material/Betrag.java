package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservice.model.material;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@RequiredArgsConstructor
@Getter
public class Betrag {
    private final Double value;
}
