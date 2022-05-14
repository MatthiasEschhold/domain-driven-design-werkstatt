package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.arbeitswert.kostensatz;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.common.Menge;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
@RequiredArgsConstructor
public class Arbeitswert {
    private final Geldwert geldwert;
    private final Zeitwert zeitwert;
    private final Waehrung waehrung;
    private final Menge menge;
}
