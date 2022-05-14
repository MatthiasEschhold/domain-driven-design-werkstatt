package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterComparator;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.*;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattauftragRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattterminId;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.joda.time.DateTime;

import java.util.*;

@AggregateRoot
@Getter
public class Werkstattplan {

    private WerkstattplanId werkstattplanId;
    private Werkstattplanstatus status;
    private Set<Tagesplan> tagesplaene;
    private Set<Bearbeiter> bearbeiters;

    public Werkstattplan() {
        this.bearbeiters = new TreeSet<>(new BearbeiterComparator());
        this.tagesplaene = new TreeSet<>(new TagesplanComparator());
    }

    public Werkstattplan(Set<Tag> tage, Set<Bearbeiter> bearbeiters) {
        this();
        this.status = new Werkstattplanstatus(WerkstattplanstatusEnum.AKTIV.getValue());
        this.bearbeiters = bearbeiters;
        this.intialisiereTagesplaene(tage);
    }

    public Werkstattplan(WerkstattplanId werkstattplanId, Werkstattplanstatus status) {
        this();
        this.werkstattplanId = werkstattplanId;
        this.status = status;
    }

    public void rolloverTagesplan() {
        Tagesplan tagesplan = this.tagesplaene.stream()
                .filter(t -> t.getTagesplanstatus().getValue().equals(TagesplanstatusEnum.AKTIV))
                .findFirst()
                .orElseThrow(() -> new TagesplanFindungException("Tagesplan kann nicht gefunden werden"));
        tagesplan.statusAendern(new Tagesplanstatus(TagesplanstatusEnum.VERGANGEN.getValue()));
        Tagesplan aktiverTagesplan = this.tagesplaene.stream().filter(t -> isNextTagesplan(t))
                .findFirst().orElse(createTagesplan(detectNextTag(tagesplan.getTag())));
        aktiverTagesplan.statusAendern(new Tagesplanstatus(TagesplanstatusEnum.AKTIV.getValue()));
        this.tagesplaene.add(aktiverTagesplan);
        this.addNewTagesplan(((Tagesplan) ((TreeSet) this.tagesplaene).first()));
    }

    private void addNewTagesplan(Tagesplan neuesterTagesplan) {
        DateTime dateTime = TagFormat.PARSE(neuesterTagesplan.getTag());
        this.tagesplaene.add(createTagesplan(new Tag(dateTime.plusDays(1).toString())));
    }

    private Tag detectNextTag(Tag tag) {
        return new Tag("");
    }

    private boolean isNextTagesplan(Tagesplan t) {
        return true;
    }

    public void werkstattauftragPlanen(WerkstattauftragRef werkstattauftragRef, Bearbeiter bearbeiter, Zeitbedarf zeitbedarf) {
        /**
         * Suche des nächsten zusammengehängenden Zeitraum im Werkstattplan
         *  Ist ein Bearbeiter gesetzt, ist dieser zu verwenden
         *  Ist kein Bearbeiter gesetzt, ist dieser zu ermitteln passend zur Qualififkation (Mechantroniker vs. Karrosseriebauer)
         *
         * Ist der Auftrag bereits eingeplant und dieser quasi verschoben wird muss der alte Zeitraum freigegeben werden
         *
         * Wird innerhalb von 4 Wochen kein Zeitraum automatisch gefunden, muss eine manuelle Pruefung erfolgen
         */
        this.tagesplaene.stream().forEach(t -> {
            if (t.findeUndReserviereWerkstatttermin(zeitbedarf, bearbeiter, werkstattauftragRef)) {
                return;
            }
        });
    }

    public void werkstattauftragPlanen(WerkstattauftragRef werkstattauftragRef, Zeitbedarf zeitbedarf) {
        /**
         * Suche des nächsten zusammengehängenden Zeitraum im Werkstattplan
         *  Ist ein Bearbeiter gesetzt, ist dieser zu verwenden
         *  Ist kein Bearbeiter gesetzt, ist dieser zu ermitteln passend zur Qualififkation (Mechantroniker vs. Karrosseriebauer)
         *
         * Ist der Auftrag bereits eingeplant und dieser quasi verschoben wird muss der alte Zeitraum freigegeben werden
         *
         * Wird innerhalb von 4 Wochen kein Zeitraum automatisch gefunden, muss eine manuelle Pruefung erfolgen
         */
        this.tagesplaene.stream().forEach(t -> {
            if (t.findeUndReserviereWerkstatttermin(zeitbedarf, werkstattauftragRef)) {
                return;
            }
        });
    }

    public Werkstatttermin bearbeiterZuordnen(WerkstattterminId werkstattterminId, Bearbeiter bearbeiter) {
        Werkstatttermin werkstatttermin = findWerkstatttermin(werkstattterminId)
                .orElseThrow(() -> new BearbeiterZuordnungException("Kein Termin mit Id " + werkstattterminId.getValue() + " vorhanden!"));
        werkstatttermin.bearbeiterZuordnen(bearbeiter);
        return werkstatttermin;
    }

    private Optional<Werkstatttermin> findWerkstatttermin(WerkstattterminId terminId) {
        List<Werkstatttermin> termine = new ArrayList<>();
        tagesplaene.stream().forEach(tagesplan -> termine.addAll(tagesplan.getWerkstatttermine()));
        return termine.stream().filter(termin -> termin.getTerminId().equals(terminId)).findFirst();
    }

    /**
     * Factory im DDD Sinne. Factroy Method als Muster
     *
     * @param tag
     * @return
     */
    private Tagesplan createTagesplan(Tag tag) {
        return new Tagesplan(tag, ermittleVerfuegbareBearbeiterfuerTagesplan(tag));
    }

    public Set<Bearbeiter> ermittleVerfuegbareBearbeiterfuerTagesplan(Tag tag) {
        //... Nicht jeder Bearbeiter ist jeden Tag 8 Stunden da! Urlaub, private Termine, Krankheit, ...
        return bearbeiters;
    }

    public void intialisiereTagesplaene(Set<Tag> tage) {
        tage.stream().forEach(t -> this.tagesplaene.add(new Tagesplan(t, ermittleVerfuegbareBearbeiterfuerTagesplan(t))));
    }

    public void addTagesplaene(Set<Tagesplan> tagesplaene) {
        this.tagesplaene.addAll(tagesplaene);
    }
}
