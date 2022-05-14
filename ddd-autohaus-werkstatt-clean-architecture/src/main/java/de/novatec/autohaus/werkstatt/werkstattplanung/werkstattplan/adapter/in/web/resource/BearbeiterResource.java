package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.web.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import lombok.Data;

@Resource
@Data
public class BearbeiterResource {
    private Long id;
    private String name;
    private String vorname;
}
