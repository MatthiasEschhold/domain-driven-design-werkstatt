package ddd.autohaus.tacticald.design.app.werkstattauftrag.model;

import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftraggeber.Auftraggeber;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsposition.Auftragsposition;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsposition.Material;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsstatus.WerkstattauftragstatusEnum;
import ddd.autohaus.tacticald.design.common.InvariantException;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
public class Werkstattauftrag {

    private Long werkstattauftragsnummer;
    private WerkstattauftragstatusEnum werkstattauftragsstatus;
    private Auftraggeber auftraggeber;
    private Set<Auftraggeber> auftraggeberHistorie;
    private List<Long> bearbeiterverlauf;
    private Long aktuellerBearbeiter;
    private Set<Auftragsposition> auftragspositionen;
    private LocalDateTime erstellungsdatum;
    private List<Material> zusaetzlicheMaterialien;
    private String fahrzeugkennzeichen;

    public Werkstattauftrag() {
    }

    public Werkstattauftrag(Auftraggeber auftraggeber) {
        this.auftraggeber = auftraggeber;
    }

    public Werkstattauftrag(Auftraggeber auftraggeber, Long aktuellerBearbeiter) {
        this.auftraggeber = auftraggeber;
    }


    public void auftragspositionAktualisieren(Long auftragspositionnummer, Double menge) {
        Auftragsposition auftragsposition = findAuftragsposition(auftragspositionnummer);
        auftragsposition.mengeAendern(menge);
    }

    public void auftraggeberAendern(Auftraggeber neuerAuftraggeber) {
        if (!neuerAuftraggeber.equals(this.auftraggeber)) {
            this.auftraggeberHistorie.add(this.auftraggeber);
            this.auftraggeber = neuerAuftraggeber;
        }
    }

    public void bearbeiterAendern(Long bearbeiter) {
        if (bearbeiter != null) {
            if (!bearbeiter.equals(this.aktuellerBearbeiter)) {
                this.bearbeiterverlauf.add(this.aktuellerBearbeiter);
                this.aktuellerBearbeiter = bearbeiter;
            } else {
                throw new InvariantException("Dies ergibt zwar keinen Sinn, könnte man aber auch ignorieren");
            }
        } else {
            throw new InvariantException("Ein Bearbeiter kann nicht durch 'Nichts' (Domänensprache für null) ausgetauscht werden!");
        }
    }

    public void auftragsstatusAendern(WerkstattauftragstatusEnum newWerkstattauftragsstatus) {
        this.werkstattauftragsstatus = newWerkstattauftragsstatus;
    }

    public void auftragspositionHinzufuegen(Auftragsposition auftragsposition) {
        if (auftragsposition != null) {
            this.auftragspositionen.add(auftragsposition);
        } else {
            throw new InvariantException("AuftragspositionTyp darf nicht null sein!");
        }
    }

    private Auftragsposition findAuftragsposition(Long auftragspositionnummer) {
        return this.auftragspositionen.stream()
                .filter(a -> a.getAuftragspositionsnummer().equals(auftragspositionnummer))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Auftragsposition mit Auftragspositionsnummer "
                        + auftragspositionnummer + " nicht gefunden"));
    }

}
