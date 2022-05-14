package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
@EqualsAndHashCode
public class Auftragspositionnummer {
    private String value;

    public Auftragspositionnummer(String value) {
        this.value = value;
        checkIfValueObjectIsNull(this.value, "Auftragspositionsnummer");
    }
}
