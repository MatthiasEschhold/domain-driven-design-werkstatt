package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity.WerkstattplanDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WerkstattplanDbRepository extends JpaRepository<WerkstattplanDbEntity, Long> {
    List<WerkstattplanDbEntity> findAllByStatusEquals(String status);
}
