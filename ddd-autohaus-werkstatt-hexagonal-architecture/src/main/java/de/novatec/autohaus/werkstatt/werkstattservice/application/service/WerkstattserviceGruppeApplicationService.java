package de.novatec.autohaus.werkstatt.werkstattservice.application.service;

import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werksattservicegruppe.CreateWerkstattserviceGruppe;
import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werksattservicegruppe.ReadWerkstattserviceGruppe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WerkstattserviceGruppeApplicationService implements CreateWerkstattserviceGruppe, ReadWerkstattserviceGruppe {

}
