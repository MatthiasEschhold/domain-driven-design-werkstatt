package de.novatec.autohaus.werkstatt.werkstattservice.adapter.in.web.werkstattservice;

import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werkstattservice.CreateWerkstattservice;
import de.novatec.autohaus.werkstatt.werkstattservice.application.port.in.werkstattservice.ReadWerkstattservice;
import de.novatec.autohaus.werkstatt.jmolecules.InputAdapter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@InfrastructureRing
@InputAdapter
@RestController
@RequestMapping("/werkstattservice")
@RequiredArgsConstructor
public class WerkstattserviceController {
    private final CreateWerkstattservice createWerkstattservice;
    private final ReadWerkstattservice readWerkstattservice;
}
