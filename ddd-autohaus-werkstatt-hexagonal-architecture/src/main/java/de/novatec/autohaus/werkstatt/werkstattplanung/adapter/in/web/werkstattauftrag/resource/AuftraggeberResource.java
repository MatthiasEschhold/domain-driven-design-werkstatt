package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattauftrag.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

@InfrastructureRing
@Resource
public class AuftraggeberResource {

    private String typ;
    private Long id;
    private String name;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
