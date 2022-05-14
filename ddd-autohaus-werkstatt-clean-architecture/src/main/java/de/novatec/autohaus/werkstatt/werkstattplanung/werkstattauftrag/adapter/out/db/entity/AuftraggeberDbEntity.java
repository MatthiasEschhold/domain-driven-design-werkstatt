package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AUFTRAGGEBER")
public class AuftraggeberDbEntity extends AbstractAuftraggeberDbObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUFTRAGGEBER_ID")
    private Long auftraggeberId;

    @ManyToOne
    @JoinColumn
    private WerkstattauftragDbEntity werkstattauftragDbEntity;
}
