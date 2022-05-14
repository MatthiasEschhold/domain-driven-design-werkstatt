package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
