package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "WERKSTATTAUFTRAG")
public class WerkstattauftragDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WERKSTATTAUFTRAGSNUMMER")
    private Long werkstattauftragsnummer;

    @Column(name = "FAHRZEUGKENNZEICHEN")
    private String fahrzeugkennzeichen;

    @Column(name = "AUFTRAGSSTATUS")
    private String auftragsstatus;

    @OneToMany
    private List<AuftraggeberDbEntity> auftraggeberHistorie;

    @OneToMany
    private List<BearbeiterDbEntity> bearbeiterHistorie;

    @Embedded
    private AuftraggeberEmbeddable auftraggeber;

    @OneToMany
    private List<AuftragspositionDbEntity> auftragspositionen;

    @Column(name = "AKTUELLER_BEARBEITER")
    private Long aktuellerBearbeiter;

    @Column(name = "ERSTELLUNGDATUM")
    private String erstellungsdatum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WerkstattauftragDbEntity that = (WerkstattauftragDbEntity) o;
        return Objects.equals(werkstattauftragsnummer, that.werkstattauftragsnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(werkstattauftragsnummer);
    }
}
