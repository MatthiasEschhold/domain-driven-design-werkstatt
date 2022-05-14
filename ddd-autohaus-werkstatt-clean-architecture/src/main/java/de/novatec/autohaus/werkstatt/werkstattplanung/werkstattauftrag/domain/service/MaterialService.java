package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.service;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.event.WerkstattauftragPlanbarDomainEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.AktualisiereMaterialstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.PublishWerkstattauftragPlanbarEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.WerkstattauftragDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.WerkstattauftragDbQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class MaterialService implements AktualisiereMaterialstatus {

    private final WerkstattauftragDbQuery werkstattauftragDbQuery;
    private final WerkstattauftragDbCommand werkstattauftragDbCommand;
    private final PublishWerkstattauftragPlanbarEvent publishWerkstattauftragPlanbarEvent;
    private final ZeitbedarfDomainService zeitbedarfDomainService;

    @Override
    public void bestellteMaterialienVerfuegbar(Werkstattauftragsnummer werkstattauftragsnummer,
                                               Set<MaterialRef> ersatzteile) {
        Werkstattauftrag werkstattauftrag = werkstattauftragDbQuery.findWerkstattauftrag(werkstattauftragsnummer);
        werkstattauftrag.verfuegbareMaterialienErmitteln(ersatzteile);
        boolean isPlanbar = werkstattauftrag.pruefeUndSetzePlanbarkeit();
        werkstattauftrag = werkstattauftragDbCommand.save(werkstattauftrag);
        if (isPlanbar) {
            publishWerkstattauftragPlanbarEvent.publish(createWerkstattauftragPlanbarDomainEvent(werkstattauftrag));
        }
    }

    @Override
    public void angefragteMaterialenBestellt(Werkstattauftragsnummer werkstattauftragsnummer, Set<MaterialRef> ersatzteile) {
        Werkstattauftrag werkstattauftrag = werkstattauftragDbQuery.findWerkstattauftrag(werkstattauftragsnummer);
        werkstattauftrag.ersatzteileBestellt(ersatzteile);
        werkstattauftragDbCommand.save(werkstattauftrag);
    }

    private WerkstattauftragPlanbarDomainEvent createWerkstattauftragPlanbarDomainEvent(Werkstattauftrag werkstattauftrag) {
        Zeitbedarf zeitbedarf = zeitbedarfDomainService.ermittleZeitbedarf(werkstattauftrag);
        if (werkstattauftrag.getAktuellerBearbeiter() != null) {
            return new WerkstattauftragPlanbarDomainEvent(werkstattauftrag.getWerkstattauftragsnummer(), zeitbedarf);
        } else {
            return new WerkstattauftragPlanbarDomainEvent(werkstattauftrag.getWerkstattauftragsnummer(),
                    werkstattauftrag.getAktuellerBearbeiter(), zeitbedarf);
        }
    }

}
