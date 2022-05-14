package de.novatec.autohaus.werkstatt.werkstattplanung.application.service.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.BearbeiterAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag.AktuellenBearbeiterAendern;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbQuery;
import de.novatec.autohaus.werkstatt.jmolecules.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.classical.ApplicationServiceRing;
import org.springframework.stereotype.Component;

@ApplicationServiceRing
@ApplicationService
@Component
@Slf4j
@RequiredArgsConstructor
public class AktuellerBearbeiterApplicationService implements AktuellenBearbeiterAendern {

    private final WerkstattauftragDbQuery werkstattauftragDbQuery;
    private final WerkstattauftragDbCommand werkstattauftragDbCommand;

    @Override
    public Werkstattauftrag aktuellenBearbeiterAendern(BearbeiterAendernCommand bearbeiterAendernCommand) {
        Werkstattauftrag werkstattauftrag = werkstattauftragDbQuery.findWerkstattauftrag(bearbeiterAendernCommand.getWerkstattauftragsnummer());
        werkstattauftrag.bearbeiterAendern(bearbeiterAendernCommand.getBearbeiterRef());
        return werkstattauftragDbCommand.save(werkstattauftrag);
    }
}
