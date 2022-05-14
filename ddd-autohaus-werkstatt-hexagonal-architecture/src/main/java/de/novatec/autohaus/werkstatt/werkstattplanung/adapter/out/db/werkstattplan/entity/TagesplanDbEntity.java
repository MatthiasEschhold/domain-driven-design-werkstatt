package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity;

import de.novatec.autohaus.werkstatt.jmolecules.DbEntity;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import javax.persistence.*;
import java.util.List;

@InfrastructureRing
@DbEntity
@Entity
@Table(name = "TAGESPLAN")
@Data
public class TagesplanDbEntity {

    @Column(name = "TAG")
    @Id
    private String tag;

    @Column(name = "TAGESPLAN_STATUS")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WerkstattterminDbEntity> werktatttermine;

    @ManyToOne
    @JoinColumn
    private WerkstattplanDbEntity werkstattplan;
}
