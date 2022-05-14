package ddd.autohaus.tacticald.design.app.werkstattauftrag.service;

import ddd.autohaus.tacticald.design.app.werkstattauftrag.factory.WerktstattauftragFactory;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.Werkstattauftrag;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftraggeber.AuftraggeberTypEnum;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.model.auftragsstatus.WerkstattauftragstatusEnum;
import ddd.autohaus.tacticald.design.app.werkstattauftrag.repository.WerkstattauftragRepository;

public class WerkstattauftragService {

    private final WerktstattauftragFactory factory;
    private final WerkstattauftragRepository repository;

    public WerkstattauftragService(WerktstattauftragFactory factory, WerkstattauftragRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    public Werkstattauftrag readWerkstattauftrag(Long werkstattauftragsnummer) {
        return this.repository.findById(werkstattauftragsnummer);
    }

    public Werkstattauftrag createWerkstattauftrag(String typ, Long auftraggeberId, String auftraggeberName, Long bearbeiterId) {
        Werkstattauftrag werkstattauftrag = factory.create(AuftraggeberTypEnum.valueOf(typ), auftraggeberId, auftraggeberName, bearbeiterId);
        return this.repository.save(werkstattauftrag);
    }

    public Werkstattauftrag createWerkstattauftrag(String typ, Long auftraggeberId, String auftraggeberName) {
        Werkstattauftrag werkstattauftrag = factory.create(AuftraggeberTypEnum.valueOf(typ), auftraggeberId, auftraggeberName);
        return this.repository.save(werkstattauftrag);
    }

    public void auftragsstatusAendern(Long auftragsnummer, String newWerkstattauftragsstatus) {
        Werkstattauftrag werkstattauftrag = this.repository.findById(auftragsnummer);
        werkstattauftrag.auftragsstatusAendern(WerkstattauftragstatusEnum.valueOf(newWerkstattauftragsstatus));
    }

}
