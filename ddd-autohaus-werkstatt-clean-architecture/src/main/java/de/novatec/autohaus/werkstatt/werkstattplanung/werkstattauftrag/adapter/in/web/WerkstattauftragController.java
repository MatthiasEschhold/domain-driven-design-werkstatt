package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource.AuftragspositionResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource.WerkstattauftragCommandResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource.WerkstattauftragResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.BearbeiterAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.WerkstattauftragAuftraggeberAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.WerkstattauftragErstellenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.WerkstattauftragsstatusAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.BearbeiterRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Fahrzeugkennzeichen;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.*;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.AktuellenBearbeiterAendern;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.WerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.WerkstattauftragQuery;
import de.novatec.autohaus.werkstatt.jmolecules.InputAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@InputAdapter
@RestController
@RequestMapping("/v1/werkstattauftraege")
@RequiredArgsConstructor
public class WerkstattauftragController {

    private final WerkstattauftragCommand command;
    private final WerkstattauftragQuery query;
    private final WerkstattauftragResourceDomainMapper mapper;
    private final AktuellenBearbeiterAendern aktuellenBearbeiterAendern;

    @PostMapping("/testdata")
    public void createTestdata() {
        List<Werkstattauftrag> werkstattauftraege = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WerkstattauftragErstellenCommand werkstattauftragErstellenCommand = new WerkstattauftragErstellenCommand(
                    new Auftraggeber(new AuftraggeberTyp(AuftraggeberTypEnum.KUNDE_PRIVAT.getValue()),
                            new AuftraggeberId(Long.valueOf(i)),
                            new AuftraggeberName("Matthias Eschhold")),
                    new Fahrzeugkennzeichen("ES-ME 38" + i)
            );
            werkstattauftragErstellenCommand.setBearbeiterId(new BearbeiterRef(Long.valueOf(i)));
            command.werkstattauftragErstellen(werkstattauftragErstellenCommand);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<List> getAllowedAuftragstatus() {
        return ResponseEntity.ok().body(query.getAllowedWerkstattauftragstatus().stream().map(s -> s.getValue()).collect(Collectors.toList()));
    }

    @GetMapping()
    public CollectionModel<WerkstattauftragResource> getWerkstattauftraege(@RequestParam(value = "status", required = false) String status) {
        Set<WerkstattauftragResource> werkstattauftragResources;
        if (null == status || status.isEmpty() || status.isBlank()) {
            werkstattauftragResources = query.leseWerkstattaustraege().stream()
                    .map(w -> mapper.mapToWerkstattauftragResource(w)).collect(Collectors.toSet());
        } else {
            werkstattauftragResources = query.leseWerkstattauftraegeWithStatus(new Werkstattauftragsstatus(status)).stream()
                    .map(w -> mapper.mapToWerkstattauftragResource(w)).collect(Collectors.toSet());
        }
        return CollectionModel.of(werkstattauftragResources,
                linkTo(WerkstattauftragController.class).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<WerkstattauftragResource> getWerkstattauftrag(@PathVariable("id") Long id) {
        return EntityModel.of(mapper.mapToWerkstattauftragResource(query.leseWerkstattauftrag(new Werkstattauftragsnummer(id))));
    }

    @PostMapping
    public EntityModel<WerkstattauftragResource> createWerkstattauftrag(@RequestBody WerkstattauftragCommandResource werkstattAuftragCommandResource) {
        Werkstattauftrag werkstattauftrag = command.werkstattauftragErstellen(createWerkstattauftragErstellenCommand(werkstattAuftragCommandResource));
        return EntityModel.of(mapper.mapToWerkstattauftragResource(werkstattauftrag));
    }

    @PutMapping("/{id}/werkstattauftragstatus")
    public EntityModel<WerkstattauftragResource> updateStatus(@PathVariable("id") Long id, @RequestBody WerkstattauftragCommandResource resource) {
        Werkstattauftrag werkstattauftrag = command.auftragsstatusAnendern(new WerkstattauftragsstatusAendernCommand(new Werkstattauftragsnummer(id),
                new Werkstattauftragsstatus(resource.getAuftragsstatus())));
        return EntityModel.of(mapper.mapToWerkstattauftragResource(werkstattauftrag));
    }

    @PutMapping("/{id}/auftraggeber")
    public EntityModel<WerkstattauftragResource> updateAuftraggeber(@PathVariable("id") Long id, @RequestBody WerkstattauftragCommandResource resource) {
        Werkstattauftrag werkstattauftrag = command.auftraggeberAendern(new WerkstattauftragAuftraggeberAendernCommand(new Werkstattauftragsnummer(id),
                mapper.mapToAuftraggeberDomain(resource.getAuftraggeber())));
        return EntityModel.of(mapper.mapToWerkstattauftragResource(werkstattauftrag));
    }

    @PutMapping("/{id}/bearbeiter")
    public EntityModel<WerkstattauftragResource> updateBearbeiter(@PathVariable("id") Long id, @RequestBody WerkstattauftragCommandResource resource) {
        Werkstattauftrag werkstattauftrag = aktuellenBearbeiterAendern.aktuellenBearbeiterAendern(new BearbeiterAendernCommand(new Werkstattauftragsnummer(id),
                new BearbeiterRef(resource.getBearbeiterId())));
        return EntityModel.of(mapper.mapToWerkstattauftragResource(werkstattauftrag));
    }

    @PostMapping("/{id}/auftragsposition")
    public EntityModel<WerkstattauftragResource> createAuftragspositionen(@PathVariable("id") Long werkstattauftragId, @RequestBody List<AuftragspositionResource> auftragspositionen) {
        throw new UnsupportedOperationException("coming soon ...");
    }

    @PutMapping("/{id}/auftragsposition/{auftragspositionId}")
    public EntityModel<WerkstattauftragResource> updateAuftragspositionen(@PathVariable("id") Long werkstattauftragId,
                                                                          @PathVariable("auftragspositionId") String auftragspositionId, @RequestBody AuftragspositionResource auftragsposition) {
        throw new UnsupportedOperationException("coming soon ...");
    }

    @GetMapping("/{id}/auftragsposition/{auftragspositionId}")
    public EntityModel<AuftragspositionResource> getAuftragsposition(@PathVariable("id") Long werkstattauftragId,
                                                                     @PathVariable("auftragspositionId") String auftragspositionId) {
        throw new UnsupportedOperationException("coming soon ...");
    }

    private WerkstattauftragErstellenCommand createWerkstattauftragErstellenCommand(WerkstattauftragCommandResource resource) {
        WerkstattauftragErstellenCommand werkstattauftragErstellenCommand = new WerkstattauftragErstellenCommand(
                mapper.mapToAuftraggeberDomain(resource.getAuftraggeber()), new Fahrzeugkennzeichen(resource.getFahrzeugkennzeichen()));
        if (resource.getBearbeiterId() != null) {
            werkstattauftragErstellenCommand.setBearbeiterId(new BearbeiterRef(resource.getBearbeiterId()));
        }
        return werkstattauftragErstellenCommand;
    }
}
