package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;

import java.util.Set;

public interface BearbeiterQuery {
    Bearbeiter getBearbeiter(BearbeiterId bearbeiterId);

    Set<Bearbeiter> getWerkstattUndKarrosserieMitarbeiter();
}
