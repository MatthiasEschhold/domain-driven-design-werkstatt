package de.novatec.autohaus.werkstatt.werkstattservice.adapter.in.web.werkstattservicegruppe;

import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werksattservicegruppe.CreateWerkstattserviceGruppe;
import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werksattservicegruppe.ReadWerkstattserviceGruppe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/werkstattservicegruppe")
@RequiredArgsConstructor
public class WerkstattserviceGruppeController {
    private final ReadWerkstattserviceGruppe readWerkstattserviceGruppe;
    private final CreateWerkstattserviceGruppe createWerkstattserviceGruppe;
}
