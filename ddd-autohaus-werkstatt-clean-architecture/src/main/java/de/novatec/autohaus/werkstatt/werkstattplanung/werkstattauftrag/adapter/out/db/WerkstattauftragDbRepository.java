package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db;


import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.db.entity.WerkstattauftragDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WerkstattauftragDbRepository extends JpaRepository<WerkstattauftragDbEntity, Long>, JpaSpecificationExecutor<WerkstattauftragDbEntity> {
    List<WerkstattauftragDbEntity> findByAuftragsstatus(List<String> status);
}