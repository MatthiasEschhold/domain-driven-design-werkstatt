package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractAuftraggeberDbObject {
    @Column(name = "AUFTRAGGEBER_NUMMER")
    private Long auftraggeberNummer;
    @Column(name = "AUFTRAGGEBER_TYP")
    private String typ;
    @Column(name = "AUFTRAGGEBER_NAME")
    private String name;
}
