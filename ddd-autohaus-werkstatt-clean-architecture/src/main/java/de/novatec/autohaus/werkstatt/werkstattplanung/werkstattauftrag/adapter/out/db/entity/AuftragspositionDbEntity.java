package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AUFTRAGSPOSITION")
public class AuftragspositionDbEntity {

    @Column(name = "AUFTRAGSPOSITIONSNUMMER")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String auftragspositionsnummer;
    @Column(name = "AUFTRAGSTYP")
    private String auftragspositionTyp;
    @Column(name = "MENGE")
    private Double menge;
    @Column(name = "SERVICE_KENNUNG")
    private String serviceKennung;
    @Column(name = "SERVICE_BEZEICHNUNG")
    private String serviceBezeichnung;
    @Column(name = "DIAGNOSE_TYP")
    private String diagnoseTyp;

    @ManyToOne
    @JoinColumn
    private WerkstattauftragDbEntity werkstattauftragDbEntity;
}
