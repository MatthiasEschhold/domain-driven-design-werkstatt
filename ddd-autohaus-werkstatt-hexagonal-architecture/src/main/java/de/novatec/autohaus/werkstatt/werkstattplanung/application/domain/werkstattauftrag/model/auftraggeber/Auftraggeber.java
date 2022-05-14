package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber;

import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class Auftraggeber {
    private final AuftraggeberTyp typ;
    private final AuftraggeberId id;
    private final AuftraggeberName name;

    public Auftraggeber(AuftraggeberTyp typ, AuftraggeberId id, AuftraggeberName name) {
        this.typ = typ;
        this.id = id;
        this.name = name;
        checkIfValueObjectIsNull(this.typ, "AuftraggeberTyp");
        checkIfValueObjectIsNull(this.id, "AuftraggeberId");
        checkIfValueObjectIsNull(this.name, "AuftraggeberName");
    }
}
