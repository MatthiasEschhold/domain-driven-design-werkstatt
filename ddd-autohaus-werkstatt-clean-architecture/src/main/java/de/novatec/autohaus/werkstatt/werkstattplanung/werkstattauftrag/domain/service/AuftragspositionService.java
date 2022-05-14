package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.service;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.AuftragspositionAktualisierenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.AuftragspositionHinzufuegenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.AuftragspositionLoeschenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.AuftragspositionCommand;
import org.springframework.stereotype.Component;

@Component
public class AuftragspositionService implements AuftragspositionCommand {

    @Override
    public Werkstattauftrag auftragspositionAktualisieren(AuftragspositionAktualisierenCommand auftragspositionAktualisierenCommand) {
        throw new UnsupportedOperationException("...");
    }

    @Override
    public Werkstattauftrag auftragspositionHinzufuegen(AuftragspositionHinzufuegenCommand auftragspositionHinzufuegenCommand) {
        throw new UnsupportedOperationException("...");
    }

    @Override
    public Werkstattauftrag auftragspositionLoeschen(AuftragspositionLoeschenCommand auftragspositionLoeschenCommand) {
        throw new UnsupportedOperationException("...");
    }

}
