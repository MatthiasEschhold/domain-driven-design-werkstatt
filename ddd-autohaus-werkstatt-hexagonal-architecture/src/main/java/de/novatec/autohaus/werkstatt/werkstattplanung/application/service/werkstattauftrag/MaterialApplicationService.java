package de.novatec.autohaus.werkstatt.werkstattplanung.application.service.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.MaterialRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.service.ZeitbedarfDomainService;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command.WerkstattauftragPlanenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattauftragRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag.AktualisiereMaterialstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan.WerkstattplanCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.bearbeiter.BearbeiterQuery;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbQuery;
import de.novatec.autohaus.werkstatt.jmolecules.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.classical.ApplicationServiceRing;
import org.springframework.stereotype.Component;

import java.util.Set;

@ApplicationServiceRing
@ApplicationService
@Slf4j
@RequiredArgsConstructor
@Component
public class MaterialApplicationService implements AktualisiereMaterialstatus {

    private final WerkstattauftragDbQuery werkstattauftragDbQuery;
    private final WerkstattauftragDbCommand werkstattauftragDbCommand;
    private final WerkstattplanCommand werkstattplanCommand;
    private final BearbeiterQuery bearbeiterQuery;
    private final ZeitbedarfDomainService zeitbedarfDomainService;

    @Override
    public void bestellteMaterialienVerfuegbar(Werkstattauftragsnummer werkstattauftragsnummer,
                                               Set<MaterialRef> ersatzteile) {
        Werkstattauftrag werkstattauftrag = werkstattauftragDbQuery.findWerkstattauftrag(werkstattauftragsnummer);
        werkstattauftrag.materialVerfuegbarkeitErmitteln(ersatzteile);
        werkstattauftrag = werkstattauftragDbCommand.save(werkstattauftrag);
        boolean isPlanbar = werkstattauftrag.pruefeUndSetzePlanbarkeit();
        werkstattauftrag = werkstattauftragDbCommand.save(werkstattauftrag);
        if (isPlanbar) {
            werkstattplanCommand.werkstattauftragPlanen(createWerkstattauftragPlanenCommand(werkstattauftrag));
        }
    }

    private WerkstattauftragPlanenCommand createWerkstattauftragPlanenCommand(Werkstattauftrag werkstattauftrag) {
        if (werkstattauftrag.getAktuellerBearbeiter() != null) {
            return new WerkstattauftragPlanenCommand(new WerkstattauftragRef(
                    werkstattauftrag.getWerkstattauftragsnummer().getValue()),
                    zeitbedarfDomainService.ermittleZeitwert(werkstattauftrag).getValue());
        } else {
            return new WerkstattauftragPlanenCommand(new WerkstattauftragRef(
                    werkstattauftrag.getWerkstattauftragsnummer().getValue()),
                    zeitbedarfDomainService.ermittleZeitwert(werkstattauftrag).getValue(),
                    bearbeiterQuery.getBearbeiter(new BearbeiterId(werkstattauftrag.getAktuellerBearbeiter().getValue())));
        }
    }

}
