package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tagesplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattauftragRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattterminId;
import lombok.Getter;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@DomainModelRing
@AggregateRoot
@Getter
public class Werkstattplan {

    private WerkstattplanId werkstattplanId;
    private Werkstattplanstatus status;
    private Set<Tagesplan> tagesplaene;

    public Werkstattplan(Set<Tagesplan> tagesplaene) {
        this.status = new Werkstattplanstatus(WerkstattplanstatusEnum.AKTIV.getValue());
        this.tagesplaene = tagesplaene;
    }

    public Werkstattplan(WerkstattplanId werkstattplanId, Werkstattplanstatus status, Set<Tagesplan> tagesplaene) {
        this.werkstattplanId = werkstattplanId;
        this.status = status;
        this.tagesplaene = tagesplaene;
    }

    public void werkstattauftragPlanen(WerkstattauftragRef werkstattauftragRef, Bearbeiter bearbeiter, Double zeitbedarf) {

    }

    public void werkstattauftragPlanen(WerkstattauftragRef werkstattauftragRef, Double zeitbedarf) {

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

    public void tagesplanHinzufuegen(Tagesplan nextTagesplan) {
        this.getTagesplaene().add(nextTagesplan);
    }
}
