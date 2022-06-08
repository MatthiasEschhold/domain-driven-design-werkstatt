package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.bearbeiter;

import de.novatec.autohaus.werkstatt.jmolecules.OutputAdapter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.BearbeiterQuery;
import org.springframework.stereotype.Component;

import java.util.Set;

@OutputAdapter
@Component
public class BearbeiterServiceClient implements BearbeiterQuery {

    @Override
    public Bearbeiter getBearbeiter(BearbeiterId bearbeiterId) {
        return null;
    }

    @Override
    public Set<Bearbeiter> getWerkstattUndKarrosserieMitarbeiter() {
        return null;
    }
}
