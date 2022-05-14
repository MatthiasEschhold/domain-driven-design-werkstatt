package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.factory;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tagesplan;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.jmolecules.ddd.annotation.Factory;

import java.util.Set;

@DomainRing
@Factory
@RequiredArgsConstructor
public class TagesplanFactory {

    public Tagesplan createTagesplan(Tag tag, Set<Bearbeiter> bearbeiter) {
        return new Tagesplan(tag, bearbeiter);
    }
}
