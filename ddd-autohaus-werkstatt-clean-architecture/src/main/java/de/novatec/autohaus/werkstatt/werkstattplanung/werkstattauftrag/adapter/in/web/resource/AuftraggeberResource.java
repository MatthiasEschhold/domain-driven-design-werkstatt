package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource;

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
