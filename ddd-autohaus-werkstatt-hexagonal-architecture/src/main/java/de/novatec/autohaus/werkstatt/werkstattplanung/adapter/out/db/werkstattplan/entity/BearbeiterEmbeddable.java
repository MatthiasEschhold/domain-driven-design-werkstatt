package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity;

import de.novatec.autohaus.werkstatt.jmolecules.DbEntity;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import javax.persistence.Embeddable;

@InfrastructureRing
@DbEntity
@Embeddable
@Data
public class BearbeiterEmbeddable {
    private Long bearbeiterId;
    private String name;
    private String vorname;
}
