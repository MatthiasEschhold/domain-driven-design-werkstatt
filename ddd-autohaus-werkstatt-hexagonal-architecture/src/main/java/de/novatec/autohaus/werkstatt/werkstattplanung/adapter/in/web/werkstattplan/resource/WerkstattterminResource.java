package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattplan.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

@InfrastructureRing
@Resource
@Data
public class WerkstattterminResource {
    private Long terminId;
    private BearbeiterResource bearbeiter;
    private Long auftragsnummer;
    private String start;
    private String ende;
}
