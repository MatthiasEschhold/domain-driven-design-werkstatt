package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterComparator;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.Ende;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.Start;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattauftragRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.Werkstatttermin;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@AggregateRoot
@Getter
public class Tagesplan {

    private Tag tag;
    private Tagesplanstatus tagesplanstatus;
    private Set<Bearbeiter> bearbeiters;
    private Set<Werkstatttermin> werkstatttermine;

    private Tagesplan() {
        this.werkstatttermine = new TreeSet<>();
        this.bearbeiters = new TreeSet<>(new BearbeiterComparator());
    }

    public Tagesplan(Tag tag, Set<Bearbeiter> bearbeiters) {
        this();
        this.tag = tag;
        this.tagesplanstatus = new Tagesplanstatus(TagesplanstatusEnum.AKTIV.getValue());
    }

    public Tagesplan(Tag tag, Set<Bearbeiter> bearbeiters, Tagesplanstatus tagesplanstatus) {
        this(tag, bearbeiters);
        this.bearbeiters = bearbeiters;
        this.tagesplanstatus = tagesplanstatus;
    }

    public Tagesplan(Tag tag, Set<Bearbeiter> bearbeiters, Tagesplanstatus tagesplanstatus, Set<Werkstatttermin> werkstatttermine) {
        this(tag, bearbeiters);
        this.bearbeiters = bearbeiters;
        this.tagesplanstatus = tagesplanstatus;
        this.werkstatttermine = werkstatttermine;
    }

    public Tagesplan(Tag tag, Tagesplanstatus tagesplanstatus) {
        this();
        this.tag = tag;
        this.tagesplanstatus = tagesplanstatus;
    }

    public void werkstattauftragBeenden(Werkstattauftragsnummer werkstattauftragsnummer) {
        throw new UnsupportedOperationException("...");
    }

    public void statusAendern(Tagesplanstatus tagesplanstatus) {
        this.tagesplanstatus = tagesplanstatus;
    }

    public boolean findeUndReserviereWerkstatttermin(Zeitbedarf zeitbedaf, WerkstattauftragRef werkstattauftragRef) {
        for (Bearbeiter bearbeiter : bearbeiters) {
            boolean result = findeUndReserviereWerkstatttermin(zeitbedaf, bearbeiter, werkstattauftragRef);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public boolean findeUndReserviereWerkstatttermin(Zeitbedarf zeitbedaf, Bearbeiter bearbeiter, WerkstattauftragRef werkstattauftragRef) {
        Optional<Start> start = findeStart(bearbeiter);
        if (start.isPresent()) {
            Ende ende = ermittleEnde(start.get(), zeitbedaf);
            this.werkstatttermine.add(new Werkstatttermin(werkstattauftragRef, bearbeiter, start.get(), ende));
            return true;
        }
        return false;
    }

    private Optional<Start> findeStart(Bearbeiter bearbeiter) {
        //...
        return Optional.of(new Start("07:30"));
    }

    private Ende ermittleEnde(Start start, Zeitbedarf zeitbedarf) {
        //...
        return new Ende("9:30");
    }

    public void addWerkstatttermin(Set<Werkstatttermin> werkstattermine) {
        this.werkstatttermine.addAll(werkstattermine);
    }
}
