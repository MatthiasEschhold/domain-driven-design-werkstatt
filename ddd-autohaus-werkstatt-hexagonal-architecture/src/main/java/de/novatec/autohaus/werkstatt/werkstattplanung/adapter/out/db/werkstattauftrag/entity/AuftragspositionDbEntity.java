package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.entity;

import de.novatec.autohaus.werkstatt.jmolecules.DbEntity;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import javax.persistence.*;

@InfrastructureRing
@DbEntity
@Entity
@Table(name = "AUFTRAGSPOSITION")
@Data
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
