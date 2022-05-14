package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity.BearbeiterEmbeddable;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity.TagesplanDbEntity;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity.WerkstattplanDbEntity;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity.WerkstattterminDbEntity;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Name;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Vorname;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tagesplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tagesplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.TagesplanstatusEnum;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.WerkstattplanId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.*;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
public class WerkstattplanDbEntityMapper {

    public WerkstattplanDbEntity mapWerkstattplanToWerkstattplanDbEntity(Werkstattplan werkstattplan) {
        WerkstattplanDbEntity dbEntity = new WerkstattplanDbEntity();
        dbEntity.setTagesplaene(werkstattplan.getTagesplaene().stream().map(t -> mapTagesplanToTagesplanDbEntity(t, dbEntity))
                .collect(Collectors.toList()));
        return dbEntity;
    }

    private TagesplanDbEntity mapTagesplanToTagesplanDbEntity(Tagesplan tagesplan, WerkstattplanDbEntity werkstattplanDbEntity) {
        TagesplanDbEntity tagesplanDbEntity = new TagesplanDbEntity();
        tagesplanDbEntity.setWerkstattplan(werkstattplanDbEntity);
        tagesplanDbEntity.setStatus(tagesplan.getTagesplanstatus().getValue());
        tagesplanDbEntity.setTag(tagesplan.getTag().getValue());
        tagesplanDbEntity.setWerktatttermine(tagesplan.getWerkstatttermine().stream()
                .map(t -> this.mapWerkstattterminToWerkstattterminDbEntity(t, tagesplanDbEntity)).collect(Collectors.toList()));
        return tagesplanDbEntity;
    }

    public WerkstattterminDbEntity mapWerkstattterminToWerkstattterminDbEntity(Werkstatttermin werkstatttermin, TagesplanDbEntity tagesplan) {
        WerkstattterminDbEntity dbEntity = new WerkstattterminDbEntity();
        dbEntity.setWerkstattauftragsnummer(werkstatttermin.getWerkstattauftragRef().getValue());
        dbEntity.setId(werkstatttermin.getTerminId().getValue());
        BearbeiterEmbeddable bearbeiterEmbeddable = new BearbeiterEmbeddable();
        bearbeiterEmbeddable.setBearbeiterId(werkstatttermin.getBearbeiter().getId().getValue());
        bearbeiterEmbeddable.setName(werkstatttermin.getBearbeiter().getName().getValue());
        bearbeiterEmbeddable.setVorname(werkstatttermin.getBearbeiter().getVorname().getValue());
        dbEntity.setBearbeiter(bearbeiterEmbeddable);
        dbEntity.setTagesplanDbEntity(tagesplan);
        return dbEntity;
    }

    public Werkstattplan mapWerkstattplanDbEntityToWerkstattplan(WerkstattplanDbEntity entity) {
        Werkstattplan werkstattplan = new Werkstattplan(new WerkstattplanId(entity.getId()),
                new Werkstattplanstatus(entity.getStatus()));
        if (entity.getTagesplaene() != null) {
            werkstattplan.addTagesplaene(entity.getTagesplaene().stream()
                    .map(this::mapTagesplanDbEntityToTagesplan).collect(Collectors.toSet()));
        }
        return werkstattplan;
    }

    public Tagesplan mapTagesplanDbEntityToTagesplan(TagesplanDbEntity entity) {
        Tagesplan tagesplan = new Tagesplan(new Tag(entity.getTag()),
                new Tagesplanstatus(TagesplanstatusEnum.valueOf(entity.getStatus()).getValue()));
        if (entity.getWerktatttermine() != null) {
            tagesplan.addWerkstatttermin(entity.getWerktatttermine().stream().map(this::mapWerkstattterminDbEntityToWerkstatttermin)
                    .collect(Collectors.toSet()));
        }
        return tagesplan;
    }

    public Werkstatttermin mapWerkstattterminDbEntityToWerkstatttermin(WerkstattterminDbEntity entity) {
        Werkstatttermin werkstatttermin = new Werkstatttermin(new WerkstattterminId(entity.getId()),
                new WerkstattauftragRef(entity.getWerkstattauftragsnummer()),
                new Bearbeiter(new BearbeiterId(entity.getBearbeiter().getBearbeiterId()),
                        new Name(entity.getBearbeiter().getName()),
                        new Vorname(entity.getBearbeiter().getVorname())), new Start(entity.getStart()), new Ende(entity.getEnde()));
        return werkstatttermin;
    }

}
