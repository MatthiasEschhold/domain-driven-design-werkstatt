package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity.TagesplanDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagesplanDbEntityRepository extends JpaRepository<TagesplanDbEntity, String> {
    List<TagesplanDbEntity> findAllByStatusEquals(String status);
}
