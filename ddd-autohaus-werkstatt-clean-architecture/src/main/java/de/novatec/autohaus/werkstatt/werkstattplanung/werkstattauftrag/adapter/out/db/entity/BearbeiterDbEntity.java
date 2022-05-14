package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BEARBEITER")
public class BearbeiterDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bearbeiterId;

    @ManyToOne
    @JoinColumn
    private WerkstattauftragDbEntity werkstattauftragDbEntity;
}
