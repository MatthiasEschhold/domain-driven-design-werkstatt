package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class BearbeiterEmbeddable {
    private Long bearbeiterId;
    private String name;
    private String vorname;
}
