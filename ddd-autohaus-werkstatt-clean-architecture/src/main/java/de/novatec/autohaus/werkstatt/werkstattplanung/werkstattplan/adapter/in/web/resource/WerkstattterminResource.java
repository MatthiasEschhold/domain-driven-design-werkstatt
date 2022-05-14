package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.web.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import lombok.Data;

@Resource
@Data
public class WerkstattterminResource {
    private Long terminId;
    private BearbeiterResource bearbeiter;
    private Long auftragsnummer;
    private String start;
    private String ende;
}
