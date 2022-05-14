package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.service;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.arbeitswert.Zeitwert;
import de.novatec.autohaus.werkstatt.jmolecules.DomainService;
import org.jmolecules.architecture.onion.classical.DomainServiceRing;
import org.springframework.stereotype.Service;

@DomainServiceRing
@DomainService
@Service
public class ZeitbedarfDomainService {

    public Zeitwert ermittleZeitwert(Werkstattauftrag werkstattauftrag) {
        return new Zeitwert(werkstattauftrag.getAuftragspositionen().stream()
                .mapToDouble(a -> a.getWerkstattservice().getArbeitswert().getZeitwert().getValue()).sum());
    }
}
