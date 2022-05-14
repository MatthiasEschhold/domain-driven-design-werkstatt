package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.bearbeiter;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.jmolecules.OutputPort;

import java.util.Set;

@OutputPort
public interface BearbeiterQuery {
    Bearbeiter getBearbeiter(BearbeiterId bearbeiterId);

    Set<Bearbeiter> findVerfuegbareWerkstattUndKarrosserieMitarbeiter(Tag tag);

    Set<Bearbeiter> getWerkstattUndKarrosserieMitarbeiter();
}
