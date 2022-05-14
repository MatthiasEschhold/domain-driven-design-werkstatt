package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.common.Menge;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.ValueObject;

import static de.novatec.autohaus.werkstatt.common.validation.DomainModelValidator.checkIfValueObjectIsNull;

@DomainModelRing
@ValueObject
@Getter
public class Material {
    private final Materialbezeichnung bezeichnung;
    private Materialstatus status;
    private final MaterialRef materialnummer;
    private final Materialpreis materialpreis;
    private Menge menge;

    public Material(Materialbezeichnung bezeichnung, MaterialRef materialnummer,
                    Materialpreis materialpreis, Menge menge, Materialstatus status) {
        this.bezeichnung = bezeichnung;
        this.materialnummer = materialnummer;
        this.materialpreis = materialpreis;
        this.menge = menge;
        this.status = status;
        checkIfValueObjectIsNull(this.bezeichnung, "AuftraggeberName");
        checkIfValueObjectIsNull(this.materialnummer, "AuftraggeberName");
        checkIfValueObjectIsNull(this.materialpreis, "AuftraggeberName");
        checkIfValueObjectIsNull(this.status, "AuftraggeberName");
        checkIfMengeIsNullAndSetDefaultValue(this.menge);
    }

    private void checkIfMengeIsNullAndSetDefaultValue(Menge menge) {
        if (menge == null) {
            this.menge = new Menge(1.0);
        }
    }

    public void statusAktualisieren(MaterialstatusEnum status) {
        this.status = new Materialstatus(status.getValue());
    }
}
