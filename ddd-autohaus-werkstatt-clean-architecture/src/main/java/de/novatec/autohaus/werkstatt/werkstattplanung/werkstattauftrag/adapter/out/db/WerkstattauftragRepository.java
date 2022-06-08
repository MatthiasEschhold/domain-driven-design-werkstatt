package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db.entity.WerkstattauftragDbEntity;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.WerkstattauftragDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.out.WerkstattauftragDbQuery;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Repository
public class WerkstattauftragRepository implements WerkstattauftragDbCommand, WerkstattauftragDbQuery {

    private WerkstattauftragDbRepository dbRepository;
    private WerkstattauftragDbEntityMapper mapper;

    @Autowired
    public WerkstattauftragRepository(WerkstattauftragDbRepository dbRepository, WerkstattauftragDbEntityMapper mapper) {
        this.dbRepository = dbRepository;
        this.mapper = mapper;
    }

    @Override
    public Werkstattauftrag save(Werkstattauftrag werkstattauftrag) {
        return mapper.mapToDomain(dbRepository.save(mapper.mapToEntity(werkstattauftrag)));
    }

    @Override
    public void archivieren(Werkstattauftragsnummer werkstattauftragsnummer) {
        throw new UnsupportedOperationException("coming soon...");
    }

    @Override
    public void aktualisiereBearbeiter(Werkstattauftragsnummer werkstattauftragsnummer, BearbeiterId bearbeiterId) {
        throw new UnsupportedOperationException("...");
    }

    @Override
    public void updateWerkstattauftragsstatus(Werkstattauftragsnummer werkstattauftragsnummer, Werkstattauftragsstatus werkstattauftragsstatus) {

    }

    @Override
    public Werkstattauftrag findWerkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer) {
        return mapper.mapToDomain(dbRepository.findById(werkstattauftragsnummer.getValue()).get());
    }

    @Override
    public List<Werkstattauftrag> findAllWerkstattauftraegeWithStatus(Werkstattauftragsstatus... werkstattauftragsstatus) {
        List<WerkstattauftragDbEntity> werkstattauftraege =
                dbRepository.findByAuftragsstatus(Arrays.stream(werkstattauftragsstatus).map(s -> s.getValue()).collect(Collectors.toList()));
        return werkstattauftraege.stream().map(w -> mapper.mapToDomain(w)).collect(Collectors.toList());
    }

    @Override
    public List<Werkstattauftrag> findWerkstattauftragOfAuftraggeber(AuftraggeberId auftraggeberId) {
        return null;
    }
}
