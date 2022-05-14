package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.service;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import org.springframework.stereotype.Service;

@Service
public class ZeitbedarfDomainService {

    public Zeitbedarf ermittleZeitbedarf(Werkstattauftrag werkstattauftrag) {
        return new Zeitbedarf(werkstattauftrag.getAuftragspositionen()
                .stream().mapToDouble(auftragsposition -> auftragsposition.ermittleTatsaechlichenZeitbedarf().getValue()).sum());
    }
}
