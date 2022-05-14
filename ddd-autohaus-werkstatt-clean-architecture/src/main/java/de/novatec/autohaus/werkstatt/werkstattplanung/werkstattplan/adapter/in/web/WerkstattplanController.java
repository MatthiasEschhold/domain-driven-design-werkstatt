package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.web;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.web.resource.BearbeiterResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.web.resource.WerkstattplanResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command.BearbeiterZuordnenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Bearbeiter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Name;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.Vorname;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.Werkstattplan;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattterminId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in.WerkstattplanCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in.WerkstattplanQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
