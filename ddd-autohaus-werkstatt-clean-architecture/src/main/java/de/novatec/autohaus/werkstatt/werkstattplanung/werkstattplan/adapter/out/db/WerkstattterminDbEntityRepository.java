package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.db.entity.WerkstattterminDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WerkstattterminDbEntityRepository extends JpaRepository<WerkstattterminDbEntity, Long> {

}
