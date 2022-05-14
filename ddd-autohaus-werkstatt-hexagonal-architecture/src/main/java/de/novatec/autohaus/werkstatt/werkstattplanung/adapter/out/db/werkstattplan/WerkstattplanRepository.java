package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity.WerkstattterminDbEntity;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tagesplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tagesplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplanstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.Werkstatttermin;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattterminId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattplan.WerkstattplanDbCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.out.werkstattplan.WerkstattplanDbQuery;
import de.novatec.autohaus.werkstatt.jmolecules.OutputAdapter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@InfrastructureRing
@OutputAdapter
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
