package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattplan.entity.WerkstattterminDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WerkstattterminDbEntityRepository extends JpaRepository<WerkstattterminDbEntity, Long> {

}
