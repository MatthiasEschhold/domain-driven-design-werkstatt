package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.BearbeiterAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;

public interface AktuellenBearbeiterAendern {
    Werkstattauftrag aktuellenBearbeiterAendern(BearbeiterAendernCommand bearbeiterAendernCommand);
}
