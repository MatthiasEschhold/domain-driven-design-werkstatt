package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.out.db.werkstattauftrag.entity.WerkstattauftragDbEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Repository
public interface WerkstattauftragDbRepository extends JpaRepository<WerkstattauftragDbEntity, Long>, JpaSpecificationExecutor<WerkstattauftragDbEntity> {
    static Specification<WerkstattauftragDbEntity> findByAuftragsstatus(List<String> status) {
        return (root, query, builder) -> builder.or(status.stream()
                .map(value -> builder.equal(root.get("auftragsstatus"), value))
                .toArray(Predicate[]::new));
    }
}
