package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.BearbeiterAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.jmolecules.InputPort;

@InputPort
public interface AktuellenBearbeiterAendern {
    Werkstattauftrag aktuellenBearbeiterAendern(BearbeiterAendernCommand bearbeiterAendernCommand);
}
