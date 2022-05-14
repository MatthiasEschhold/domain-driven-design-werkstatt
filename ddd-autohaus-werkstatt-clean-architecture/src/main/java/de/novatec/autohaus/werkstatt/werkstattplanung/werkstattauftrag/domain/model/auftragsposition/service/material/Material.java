package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.common.Menge;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Material {
    private final Materialbezeichnung bezeichnung;
    private Materialstatus status;
    private final MaterialRef materialnummer;
    private final Materialpreis materialpreis;
    private final Menge menge;

    public Material(Materialbezeichnung bezeichnung, MaterialRef materialnummer,
                    Materialpreis materialpreis, Menge menge, Materialstatus status) {
        this.bezeichnung = bezeichnung;
        this.materialnummer = materialnummer;
        this.materialpreis = materialpreis;
        this.menge = menge;
        this.status = status;
    }

    public void statusAktualisieren(MaterialstatusEnum status) {
        this.status = new Materialstatus(status.getValue());
    }
}
