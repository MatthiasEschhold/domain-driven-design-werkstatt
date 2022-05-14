package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.web.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import lombok.Data;

import java.util.List;

@Resource
@Data
public class WerkstattplanResource {
    private List<WerkstattterminResource> werkstattauftraege;
    private List<TagesplanResource> tagesplaene;
}
