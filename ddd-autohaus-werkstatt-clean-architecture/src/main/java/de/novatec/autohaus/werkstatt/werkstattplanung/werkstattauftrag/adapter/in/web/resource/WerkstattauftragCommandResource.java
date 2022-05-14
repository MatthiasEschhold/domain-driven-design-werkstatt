package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource;

import lombok.Data;

@Data
public class WerkstattauftragCommandResource {
    private Long bearbeiterId;
    private AuftraggeberResource auftraggeber;
    private String auftragsstatus;
    private String fahrzeugkennzeichen;

}
