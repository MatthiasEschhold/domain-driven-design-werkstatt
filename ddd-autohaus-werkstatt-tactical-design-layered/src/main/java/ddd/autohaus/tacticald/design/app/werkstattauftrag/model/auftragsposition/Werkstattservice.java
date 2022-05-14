package ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsposition;

import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

import java.util.List;

@Entity
@Getter
public class Werkstattservice {
    private String bezeichnung;
    private Long werkstattserviceRef;
    private Arbeitswert arbeitswert;
    private List<Material> materialien;


}
