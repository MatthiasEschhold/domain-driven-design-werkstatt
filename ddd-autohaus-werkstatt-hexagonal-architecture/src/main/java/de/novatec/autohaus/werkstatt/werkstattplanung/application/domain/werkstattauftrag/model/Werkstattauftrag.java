package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.Auftraggeber;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.Auftragsposition;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.Auftragspositionnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.Material;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.WerkstattauftragstatusEnum;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.common.Menge;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DomainModelRing
@AggregateRoot
@Getter
public class Werkstattauftrag {

    private Werkstattauftragsnummer werkstattauftragsnummer;
    private Werkstattauftragsstatus werkstattauftragsstatus;
    private Auftraggeber auftraggeber;
    private Set<Auftraggeber> auftraggeberHistorie;
    private List<BearbeiterRef> bearbeiterverlauf;
    private BearbeiterRef aktuellerBearbeiter;
    private Set<Auftragsposition> auftragspositionen;
    private Erstellungsdatum erstellungsdatum;
    private List<Material> zusaetzlicheMaterialien;
    private Fahrzeugkennzeichen fahrzeugkennzeichen;

    public Werkstattauftrag(Auftraggeber auftraggeber, Erstellungsdatum erstellungsdatum, Fahrzeugkennzeichen fahrzeugkennzeichen) {
        this.auftraggeber = auftraggeber;
        this.erstellungsdatum = erstellungsdatum;
        this.fahrzeugkennzeichen = fahrzeugkennzeichen;
        this.werkstattauftragsstatus = new Werkstattauftragsstatus(WerkstattauftragstatusEnum.PLANBAR.getValue());
        this.bearbeiterverlauf = new ArrayList<>();
        this.auftragspositionen = new HashSet<>();
        this.auftraggeberHistorie = new HashSet<>();
        this.zusaetzlicheMaterialien = new ArrayList<>();
        this.checkInvariants();
    }

    public Werkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer, Erstellungsdatum erstellungsdatum, Fahrzeugkennzeichen fahrzeugkennzeichen, Werkstattauftragsstatus werkstattauftragsstatus, Auftraggeber auftraggeber,
                            List<BearbeiterRef> bearbeiterverlauf, BearbeiterRef aktuellerBearbeiterRef,
                            Set<Auftragsposition> auftragspositionen, Set<Auftraggeber> auftraggeberHistorie) {
        this.werkstattauftragsnummer = werkstattauftragsnummer;
        this.werkstattauftragsstatus = werkstattauftragsstatus;
        this.fahrzeugkennzeichen = fahrzeugkennzeichen;
        this.auftraggeber = auftraggeber;
        this.bearbeiterverlauf = bearbeiterverlauf;
        this.aktuellerBearbeiter = aktuellerBearbeiterRef;
        this.auftragspositionen = auftragspositionen;
        this.erstellungsdatum = erstellungsdatum;
        this.auftraggeberHistorie = auftraggeberHistorie;
        this.zusaetzlicheMaterialien = new ArrayList<>();
    }

    public void auftragspositionAktualisieren(Auftragspositionnummer auftragspositionnummer, Menge menge) {
        Auftragsposition auftragsposition = findAuftragsposition(auftragspositionnummer);
        auftragsposition.changeMenge(menge);
    }

    public void auftraggeberAendern(Auftraggeber neuerAuftraggeber) {
        if (!neuerAuftraggeber.equals(this.auftraggeber)) {
            this.auftraggeberHistorie.add(this.auftraggeber);
            this.auftraggeber = neuerAuftraggeber;
        }
    }

    public void bearbeiterAendern(BearbeiterRef bearbeiter) {
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

    public void auftragsstatusAendern(Werkstattauftragsstatus newWerkstattauftragsstatus) {
        /**
         * Fachliche Bedingungen für Statusübergang prüfen
         */
        this.werkstattauftragsstatus = werkstattauftragsstatus;
    }

    public void auftragspositionHinzufuegen(Auftragsposition auftragsposition) {
        if (auftragsposition != null) {
            this.auftragspositionen.add(auftragsposition);
        } else {
            throw new InvariantException("AuftragspositionTyp darf nicht null sein!");
        }
    }

    public boolean pruefeUndSetzePlanbarkeit() {
        /**
         * Fachliche Bedingungen für Statusübergang prüfen
         */
        this.werkstattauftragsstatus = new Werkstattauftragsstatus(WerkstattauftragstatusEnum.PLANBAR.getValue());
        return true;
    }

    public void materialVerfuegbarkeitErmitteln(Set<MaterialRef> ersatzteile) {
        throw new UnsupportedOperationException("...");
    }

    public void ersatzteileBestellt(Set<MaterialRef> ersatzteile) {
        throw new UnsupportedOperationException("...");
    }

    private void checkInvariants() {
        if (auftraggeber == null) {
            throw new InvariantException("Auftraggeber muss vorhanden sein!");
        }
        if (erstellungsdatum == null) {
            throw new InvariantException("Erstellungsdatum muss gesetzt sein!");
        }
        if (fahrzeugkennzeichen == null) {
            throw new InvariantException("Fahrzeugkennzeichen muss vorhanden sein!");
        }
        if (werkstattauftragsstatus == null) {
            throw new InvariantException("Werkstattauftragsstatus muss vorhanden sein!");
        }
    }

    private Auftragsposition findAuftragsposition(Auftragspositionnummer auftragspositionnummer) {
        return this.auftragspositionen.stream()
                .filter(a -> a.getAuftragspositionsnummer().getValue().equals(auftragspositionnummer.getValue()))
                .findFirst()
                .orElseThrow(() -> new InvariantException("Auftragsposition mit Auftragspositionsnummer "
                        + auftragspositionnummer.getValue() + " nicht gefunden"));
    }

}
