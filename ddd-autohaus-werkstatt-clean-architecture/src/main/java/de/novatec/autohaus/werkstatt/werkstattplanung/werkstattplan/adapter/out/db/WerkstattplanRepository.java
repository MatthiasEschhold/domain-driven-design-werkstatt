package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity.WerkstattterminDbEntity;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tagesplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tagesplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattterminId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.WerkstattplanDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.out.WerkstattplanDbQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class WerkstattplanRepository implements WerkstattplanDbCommand, WerkstattplanDbQuery {

    private final WerkstattplanDbRepository werkstattplanDbEntityRepository;
    private final WerkstattterminDbEntityRepository werkstattterminDbEntityRepository;
    private final TagesplanDbEntityRepository tagesplanDbEntityRepository;
    private final WerkstattplanDbEntityMapper dbEntityMapper;

    @Override
    public Optional<Werkstatttermin> findWerkstatttermin(WerkstattterminId werkstattterminId) {
        Optional<WerkstattterminDbEntity> queryResult = this.werkstattterminDbEntityRepository.findById(werkstattterminId.getValue());
        if (queryResult.isPresent()) {
            return queryResult.map(dbEntityMapper::mapWerkstattterminDbEntityToWerkstatttermin);
        }
        return Optional.empty();
    }

    @Override
    public Set<Tagesplan> findAllTagesplaeneWithStatus(Tagesplanstatus tagesplanstatus) {
        return tagesplanDbEntityRepository.findAllByStatusEquals(tagesplanstatus.getValue())
                .stream().map(t -> dbEntityMapper.mapTagesplanDbEntityToTagesplan(t)).collect(Collectors.toSet());
    }

    @Override
    public List<Werkstatttermin> findAllWerkstatttermine() {
        return werkstattterminDbEntityRepository.findAll().stream()
                .map(dbEntityMapper::mapWerkstattterminDbEntityToWerkstatttermin).collect(Collectors.toList());
    }

    @Override
    public List<Werkstattplan> findAllWerkstattplaeneWithStatus(Werkstattplanstatus werkstattplanStatus) {
        return werkstattplanDbEntityRepository.findAllByStatusEquals(werkstattplanStatus.getValue())
                .stream().map(dbEntityMapper::mapWerkstattplanDbEntityToWerkstattplan).collect(Collectors.toList());
    }

    @Override
    public Werkstattplan saveWerkstattplan(Werkstattplan wekrstattplan) {
        return dbEntityMapper.mapWerkstattplanDbEntityToWerkstattplan(
                werkstattplanDbEntityRepository.save(dbEntityMapper.mapWerkstattplanToWerkstattplanDbEntity(wekrstattplan)));
    }

}
