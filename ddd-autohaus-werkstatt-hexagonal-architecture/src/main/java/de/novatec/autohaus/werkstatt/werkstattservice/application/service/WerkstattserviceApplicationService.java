package de.novatec.autohaus.werkstatt.werkstattservice.application.service;

import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werkstattservice.CreateWerkstattservice;
import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werkstattservice.ReadWerkstattservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WerkstattserviceApplicationService implements CreateWerkstattservice, ReadWerkstattservice {

}
