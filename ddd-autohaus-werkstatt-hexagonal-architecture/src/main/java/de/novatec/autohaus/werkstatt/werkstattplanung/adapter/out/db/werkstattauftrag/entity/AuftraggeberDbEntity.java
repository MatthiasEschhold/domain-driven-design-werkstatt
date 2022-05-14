package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.entity;

import de.novatec.autohaus.werkstatt.jmolecules.DbEntity;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import javax.persistence.*;

@InfrastructureRing
@DbEntity
@Entity
@Table(name = "AUFTRAGGEBER")
@Data
public class AuftraggeberDbEntity extends AbstractAuftraggeberDbObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUFTRAGGEBER_ID")
    private Long auftraggeberId;

    @ManyToOne
    @JoinColumn
    private WerkstattauftragDbEntity werkstattauftragDbEntity;
}
