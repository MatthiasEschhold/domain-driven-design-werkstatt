package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.web.resource;

import lombok.Data;

import java.util.List;

@Data
public class TagesplanResource {
    private String tag;
    private List<WerkstattterminResource> werkstattauftraege;
}
