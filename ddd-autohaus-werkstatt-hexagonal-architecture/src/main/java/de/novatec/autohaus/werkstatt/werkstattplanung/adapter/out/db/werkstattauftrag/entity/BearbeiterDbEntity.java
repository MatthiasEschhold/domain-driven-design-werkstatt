package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.entity;

import de.novatec.autohaus.werkstatt.jmolecules.DbEntity;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import javax.persistence.*;

@InfrastructureRing
@DbEntity
@Entity
@Table(name = "BEARBEITER")
@Data
public class BearbeiterDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bearbeiterId;

    @ManyToOne
    @JoinColumn
    private WerkstattauftragDbEntity werkstattauftragDbEntity;
}
