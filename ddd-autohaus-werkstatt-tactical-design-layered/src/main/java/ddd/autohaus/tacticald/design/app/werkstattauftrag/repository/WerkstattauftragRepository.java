package ddd.autohaus.tacticald.design.app.werkstattauftrag.repository;

import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.Werkstattauftrag;

public class WerkstattauftragRepository {

    public Werkstattauftrag findById(Long value) {
        //technischer Code für die Kommunikation mit der Datenbank
        return new Werkstattauftrag();
    }

    public Werkstattauftrag save(Werkstattauftrag werkstattauftrag) {
        //technischer Code für die Kommunikation mit der Datenbank
        return werkstattauftrag;
    }
}
