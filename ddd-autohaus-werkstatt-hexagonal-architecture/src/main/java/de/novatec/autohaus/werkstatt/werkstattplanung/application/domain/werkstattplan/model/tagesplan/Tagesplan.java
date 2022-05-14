package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.VerfuegbarsterBearbeiterComparator;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Ende;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Start;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattauftragRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.jmolecules.DomainModelBehavior;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@DomainModelRing
@AggregateRoot
@Getter
public class Tagesplan {

    private Tag tag;
    private Tagesplanstatus tagesplanstatus;
    private Set<Bearbeiter> verfuegbareBearbeiter;
    private Set<Werkstatttermin> werkstatttermine;

    public Tagesplan(Tag tag, Set<Bearbeiter> verfuegbareBearbeiter) {
        this.werkstatttermine = new TreeSet<>();
        this.verfuegbareBearbeiter = verfuegbareBearbeiter;
        this.verfuegbareBearbeiter.stream().sorted(new VerfuegbarsterBearbeiterComparator());
        this.tagesplanstatus = new Tagesplanstatus(TagesplanstatusEnum.AKTIV.getValue());
    }

    public Tagesplan(Tag tag, Set<Bearbeiter> verfuegbareBearbeiter, Tagesplanstatus tagesplanstatus) {
        this(tag, verfuegbareBearbeiter);
        this.verfuegbareBearbeiter = verfuegbareBearbeiter;
        this.tagesplanstatus = tagesplanstatus;
    }

    public Tagesplan(Tag tag, Tagesplanstatus tagesplanstatus, Set<Werkstatttermin> werkstatttermine) {
        this.tag = tag;
        this.tagesplanstatus = tagesplanstatus;
        this.werkstatttermine = werkstatttermine;
    }

    @DomainModelBehavior
    public Werkstatttermin findeUndReserviereWerkstatttermin(Double zeitbedarf, Bearbeiter bearbeiter, WerkstattauftragRef werkstattauftragRef) {
        Optional<Start> start = findeStart(bearbeiter);
        if (start.isPresent()) {
            Ende ende = ermittleEnde(start.get(), zeitbedarf);
            Werkstatttermin termin = new Werkstatttermin(werkstattauftragRef, bearbeiter, start.get(), ende);
            this.werkstatttermine.add(termin);
            return termin;
        }
        throw new AutomatischeTerminfindungException("Ein Termin kann nicht automatissch ermittelt werden!");
    }

    public void aktualisiereVerfuegbareBearbeiter(Set<Bearbeiter> verfuegbareBearbeiter) {
        this.verfuegbareBearbeiter = verfuegbareBearbeiter;
    }

    private Optional<Start> findeStart(Bearbeiter bearbeiter) {
        //...
        return Optional.of(new Start("07:30"));
    }

    private Ende ermittleEnde(Start start, Double zeitbedarf) {
        //...
        return new Ende("9:30");
    }

    public void statusAktualisieren(Tagesplanstatus tagesplanstatus) {
    }
}
