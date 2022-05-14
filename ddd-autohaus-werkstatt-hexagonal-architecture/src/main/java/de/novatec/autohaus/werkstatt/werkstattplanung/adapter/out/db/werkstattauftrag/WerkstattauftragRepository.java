package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.entity.WerkstattauftragDbEntity;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattauftrag.WerkstattauftragDbQuery;
import de.novatec.autohaus.werkstatt.jmolecules.OutputAdapter;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.WerkstattauftragDbRepository.findByAuftragsstatus;

@InfrastructureRing
@OutputAdapter
@Repository
@Component
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
        throw new UnsupportedOperationException("coming soon...");
    }

    @Override
    public Werkstattauftrag findWerkstattauftrag(Werkstattauftragsnummer werkstattauftragsnummer) {
        return mapper.mapToDomain(dbRepository.findById(werkstattauftragsnummer.getValue()).get());
    }

    @Override
    public List<Werkstattauftrag> findAllWerkstattauftraegeWithStatus(Werkstattauftragsstatus... werkstattauftragsstatus) {
        Specification<WerkstattauftragDbEntity> werkstattauftragDbEntitySpecification =
                findByAuftragsstatus(Arrays.stream(werkstattauftragsstatus).map(s -> s.getValue()).collect(Collectors.toList()));
        List<WerkstattauftragDbEntity> werkstattauftraege = dbRepository.findAll(werkstattauftragDbEntitySpecification);
        return werkstattauftraege.stream().map(w -> mapper.mapToDomain(w)).collect(Collectors.toList());
    }

    @Override
    public List<Werkstattauftrag> findWerkstattauftragOfAuftraggeber(AuftraggeberId auftraggeberId) {
        return null;
    }
}
