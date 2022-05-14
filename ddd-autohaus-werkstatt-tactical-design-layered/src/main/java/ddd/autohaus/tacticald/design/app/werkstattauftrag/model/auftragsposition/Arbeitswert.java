package ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsposition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
@RequiredArgsConstructor
public class Arbeitswert {
    private final Double geldwert;
    private final Double zeitwert;
    private final String waehrung;
    private final Double menge;
}
