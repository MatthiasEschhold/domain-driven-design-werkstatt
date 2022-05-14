package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "WERKSTATTPLAN")
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
