package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity;

import de.novatec.autohaus.werkstatt.jmolecules.DbEntity;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import javax.persistence.*;

@InfrastructureRing
@DbEntity
@Entity
@Table(name = "WERKSTATTTERMIN")
@Data
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
