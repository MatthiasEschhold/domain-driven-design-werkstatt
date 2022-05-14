package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "WERKSTATTTERMIN")
public class WerkstattterminDbEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "AUFTRAGSNUMMER")
    private Long werkstattauftragsnummer;
    @Column(name = "START")
    private String start;
    @Column(name = "ENDE")
    private String ende;
    @Embedded
    private BearbeiterEmbeddable bearbeiter;

    @ManyToOne
    @JoinColumn
    private TagesplanDbEntity tagesplanDbEntity;
}
