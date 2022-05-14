package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity;

import de.novatec.autohaus.werkstatt.jmolecules.DbEntity;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@InfrastructureRing
@DbEntity
@Entity
@Table(name = "WERKSTATTPLAN")
@Data
public class WerkstattplanDbEntity {

    @Column(name = "WERKSTATTPLAN_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "WERKSTATTPLAN_STATUS")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TagesplanDbEntity> tagesplaene;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WerkstattplanDbEntity that = (WerkstattplanDbEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
