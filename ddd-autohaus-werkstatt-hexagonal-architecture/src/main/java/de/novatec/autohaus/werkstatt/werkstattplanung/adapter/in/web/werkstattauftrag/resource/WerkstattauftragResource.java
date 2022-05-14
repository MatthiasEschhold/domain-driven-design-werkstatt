package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattauftrag.resource;


import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@InfrastructureRing
@Resource
@Data
public class WerkstattauftragResource extends RepresentationModel<WerkstattauftragResource> {
    private Long auftragsnummer;
    private String auftragsstatus;
    private AuftraggeberResource auftraggeber;
    private List<AuftragspositionResource> auftragspositionen;
    private String kennzeichen;
}
