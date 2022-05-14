package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattplan.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import java.util.List;

@InfrastructureRing
@Resource
@Data
public class WerkstattplanResource {
    private List<WerkstattterminResource> werkstattauftraege;
    private List<TagesplanResource> tagesplaene;
}
