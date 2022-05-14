package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattauftrag.resource;

import de.novatec.autohaus.werkstatt.jmolecules.Resource;
import lombok.Data;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

@InfrastructureRing
@Resource
@Data
public class WerkstattauftragCommandResource {
    private Long bearbeiterId;
    private AuftraggeberResource auftraggeber;
    private String auftragsstatus;
    private String fahrzeugkennzeichen;

}
