package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattplan;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattplan.resource.BearbeiterResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattplan.resource.WerkstattplanResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command.BearbeiterZuordnenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Name;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter.Vorname;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin.WerkstattterminId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan.WerkstattplanCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan.WerkstattplanQuery;
import de.novatec.autohaus.werkstatt.jmolecules.InputAdapter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@InfrastructureRing
@InputAdapter
@RestController
@RequestMapping("/werkstattplan")
@RequiredArgsConstructor
public class WerkstattplanController {

    private final WerkstattplanCommand werkstattplanCommand;
    private final WerkstattplanQuery werkstattplanQuery;
    private final WerkstattplanResourceDomainMapper mapper;

    @PostMapping("/testdata")
    public void createTestdata() {
        werkstattplanCommand.werkstattplanAnlegen();
    }

    @GetMapping
    public ResponseEntity<WerkstattplanResource> getWerkstattplan() {
        Werkstattplan werkstattplan = werkstattplanQuery.leseAktivenWerkstattplan();
        return ResponseEntity.status(HttpStatus.CREATED).body(
                mapper.mapWerkstattplanDtoToWerkstattplanResource(werkstattplan));
    }

    @PutMapping("/werkstatttermin/{id}/bearbeiter")
    public ResponseEntity<Void> bearbeiterAendern(@PathVariable("id") Long id, @RequestBody BearbeiterResource bearbeiterResource) {
        werkstattplanCommand.bearbeiterZuordnen(new BearbeiterZuordnenCommand(new WerkstattterminId(id),
                new Bearbeiter(new BearbeiterId(bearbeiterResource.getId()), new Name(bearbeiterResource.getName()),
                        new Vorname(bearbeiterResource.getVorname()))));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
