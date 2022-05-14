package ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsposition;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Getter
public class Material {
    private final String bezeichnung;
    private MaterialstatusEnum status;
    private final Long materialnummer;
    private final Long materialpreis;
    private final Double menge;

    public Material(String bezeichnung, Long materialnummer, Long materialpreis, Double menge) {
        this.bezeichnung = bezeichnung;
        this.materialnummer = materialnummer;
        this.materialpreis = materialpreis;
        this.menge = menge;
    }

    public Material(String bezeichnung, MaterialstatusEnum status, Long materialnummer, Long materialpreis, Double menge) {
        this(bezeichnung, materialnummer, materialpreis, menge);
        this.status = status;
    }

    public void setzteStatusAufVerfuegbar() {
        this.status = MaterialstatusEnum.VERFUEGBAR;
    }
}
