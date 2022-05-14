package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource;


import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class WerkstattauftragResource extends RepresentationModel<WerkstattauftragResource> {
    private Long auftragsnummer;
    private String auftragsstatus;
    private AuftraggeberResource auftraggeber;
    private List<AuftragspositionResource> auftragspositionen;
    private String kennzeichen;
}
