package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag;


import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.entity.*;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.*;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.Auftraggeber;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberName;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberTyp;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.Auftragsposition;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.WerkstattauftragstatusEnum;
import de.novatec.autohaus.werkstatt.jmolecules.Mapper;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@InfrastructureRing
@Mapper
@Component
public class WerkstattauftragDbEntityMapper {


    private BearbeiterRef mapToBearbeiter(BearbeiterDbEntity bearbeiterDbEntity) {
        return new BearbeiterRef(bearbeiterDbEntity.getBearbeiterId());
    }

    private Auftragsposition mapToAuftragspositionDomain(AuftragspositionDbEntity dbEntity) {
        throw new UnsupportedOperationException("...");
    }

    private Auftraggeber mapToAuftrageberDomain(AuftraggeberDbEntity dbEntity) {
        throw new UnsupportedOperationException("...");
    }

    private BearbeiterDbEntity mapToBearbeiterDbEntity(BearbeiterRef bearbeiter) {
        BearbeiterDbEntity bearbeiterDbEntity = new BearbeiterDbEntity();
        bearbeiterDbEntity.setBearbeiterId(bearbeiter.getValue());
        return bearbeiterDbEntity;
    }

    private AuftragspositionDbEntity mapToAuftragspositionEntity(Auftragsposition domainModel) {
        throw new UnsupportedOperationException("...");
    }

    private AuftraggeberDbEntity mapToAuftraggeberEntity(Auftraggeber auftraggeber) {
        throw new UnsupportedOperationException("...");
    }

    public WerkstattauftragDbEntity mapToEntity(Werkstattauftrag werkstattauftrag) {
        WerkstattauftragDbEntity dbEntity = new WerkstattauftragDbEntity();
        dbEntity.setAuftraggeber(mapToAuftraggeberEmbeddable(werkstattauftrag.getAuftraggeber()));
        dbEntity.setAktuellerBearbeiter(werkstattauftrag.getAktuellerBearbeiter().getValue());
        dbEntity.setAuftragsstatus(werkstattauftrag.getWerkstattauftragsstatus().getValue());
        dbEntity.setErstellungsdatum(werkstattauftrag.getErstellungsdatum().getValue());
        dbEntity.setFahrzeugkennzeichen(werkstattauftrag.getFahrzeugkennzeichen().getValue());
        return dbEntity;
    }

    private AuftraggeberEmbeddable mapToAuftraggeberEmbeddable(Auftraggeber auftraggeber) {
        AuftraggeberEmbeddable auftraggeberEmbeddable = new AuftraggeberEmbeddable();
        auftraggeberEmbeddable.setAuftraggeberNummer(auftraggeber.getId().getValue());
        auftraggeberEmbeddable.setName(auftraggeber.getName().getValue());
        auftraggeberEmbeddable.setTyp(auftraggeber.getTyp().getValue());
        return auftraggeberEmbeddable;
    }

    public Werkstattauftrag mapToDomain(WerkstattauftragDbEntity dbEntity) {
        Werkstattauftrag werkstattauftrag = new Werkstattauftrag(
                new Werkstattauftragsnummer(dbEntity.getWerkstattauftragsnummer()),
                new Erstellungsdatum(dbEntity.getErstellungsdatum()),
                new Fahrzeugkennzeichen(dbEntity.getFahrzeugkennzeichen()),
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.valueOf(dbEntity.getAuftragsstatus()).getValue()),
                new Auftraggeber(
                        new AuftraggeberTyp(dbEntity.getAuftraggeber().getTyp()),
                        new AuftraggeberId(dbEntity.getAuftraggeber().getAuftraggeberNummer()),
                        new AuftraggeberName(dbEntity.getAuftraggeber().getName())),
                new ArrayList<BearbeiterRef>(),
                new BearbeiterRef(dbEntity.getAktuellerBearbeiter()),
                new HashSet<Auftragsposition>(),
                new HashSet<Auftraggeber>());
        return werkstattauftrag;
    }
}
