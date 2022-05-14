package ddd.autohaus.tacticald.design.app.werkstattauftrag.factory;

import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.Werkstattauftrag;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftraggeber.Auftraggeber;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftraggeber.AuftraggeberTypEnum;

public class WerktstattauftragFactory {

    public Werkstattauftrag create(AuftraggeberTypEnum auftraggeberTyp, Long auftraggeberId, String auftraggeberName, Long bearbeiterId) {
        Auftraggeber auftraggeber = createAuftraggeber(auftraggeberTyp, auftraggeberId, auftraggeberName);
        return new Werkstattauftrag(auftraggeber, bearbeiterId);
    }

    public Werkstattauftrag create(AuftraggeberTypEnum auftraggeberTyp, Long auftraggeberId, String auftraggeberName) {
        return new Werkstattauftrag(createAuftraggeber(auftraggeberTyp, auftraggeberId, auftraggeberName));
    }

    private Auftraggeber createAuftraggeber(AuftraggeberTypEnum auftraggeberTyp, Long auftraggeberId, String auftraggeberName) {
        return new Auftraggeber(auftraggeberTyp, auftraggeberId, auftraggeberName);
    }
}
