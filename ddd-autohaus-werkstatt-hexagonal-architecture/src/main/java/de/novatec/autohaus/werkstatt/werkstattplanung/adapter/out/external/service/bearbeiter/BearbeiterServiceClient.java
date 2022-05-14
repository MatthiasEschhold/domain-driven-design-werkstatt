package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.external.service.bearbeiter;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.bearbeiter.BearbeiterQuery;
import de.novatec.autohaus.werkstatt.jmolecules.OutputAdapter;
import de.novatec.autohaus.werkstatt.jmolecules.ServiceClient;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.stereotype.Component;

import java.util.Set;

@InfrastructureRing
@OutputAdapter
@ServiceClient
@Component
public class BearbeiterServiceClient implements BearbeiterQuery {

    @Override
    public Bearbeiter getBearbeiter(BearbeiterId bearbeiterId) {
        throw new UnsupportedOperationException("coming soon ...");
    }

    @Override
    public Set<Bearbeiter> findVerfuegbareWerkstattUndKarrosserieMitarbeiter(Tag tag) {
        throw new UnsupportedOperationException("coming soon ...");
    }

    @Override
    public Set<Bearbeiter> getWerkstattUndKarrosserieMitarbeiter() {
        throw new UnsupportedOperationException("coming soon ...");
    }
}
