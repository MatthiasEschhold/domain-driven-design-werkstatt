package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.service;

import de.novatec.autohaus.werkstatt.jmolecules.ApplicationService;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.BearbeiterAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.AktuellenBearbeiterAendern;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.WerkstattauftragDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.WerkstattauftragDbQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@ApplicationService
public class AktuellerBearbeiterService implements AktuellenBearbeiterAendern {

    private final WerkstattauftragDbQuery werkstattauftragDbQuery;
    private final WerkstattauftragDbCommand werkstattauftragDbCommand;

    @Override
    public Werkstattauftrag aktuellenBearbeiterAendern(BearbeiterAendernCommand bearbeiterAendernCommand) {
        Werkstattauftrag werkstattauftrag = werkstattauftragDbQuery.findWerkstattauftrag(bearbeiterAendernCommand.getWerkstattauftragsnummer());
        werkstattauftrag.bearbeiterAendern(bearbeiterAendernCommand.getBearbeiterRef());
        return werkstattauftragDbCommand.save(werkstattauftrag);
    }
}
