package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity.TagesplanDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagesplanDbEntityRepository extends JpaRepository<TagesplanDbEntity, String> {
    List<TagesplanDbEntity> findAllByStatusEquals(String status);
}
