package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattauftrag;

import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattauftrag.resource.AuftraggeberResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.web.werkstattauftrag.resource.WerkstattauftragResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.Auftraggeber;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberName;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftraggeber.AuftraggeberTyp;
import de.novatec.autohaus.werkstatt.jmolecules.Mapper;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@InfrastructureRing
@Mapper
@Component
public class WerkstattauftragResourceDomainMapper {

    public Auftraggeber mapToAuftraggeberDomain(AuftraggeberResource resource) {
        return new Auftraggeber(new AuftraggeberTyp(resource.getTyp()),
                new AuftraggeberId(resource.getId()),
                new AuftraggeberName(resource.getName()));
    }

    public WerkstattauftragResource mapToWerkstattauftragResource(Werkstattauftrag domainModel) {
        WerkstattauftragResource resource = new WerkstattauftragResource();
        Link selfLink = linkTo(WerkstattauftragController.class).slash(domainModel.getWerkstattauftragsnummer().getValue()).withSelfRel();
        resource.setAuftragsnummer(domainModel.getWerkstattauftragsnummer().getValue());
        resource.setAuftraggeber(mapToAuftraggeberResource(domainModel.getAuftraggeber()));
        resource.setAuftragsstatus(domainModel.getWerkstattauftragsstatus().getValue());
        resource.setKennzeichen(domainModel.getFahrzeugkennzeichen().getValue());
        resource.add(selfLink);
        return resource;
    }

    private AuftraggeberResource mapToAuftraggeberResource(Auftraggeber auftraggeber) {
        AuftraggeberResource resource = new AuftraggeberResource();
        resource.setId(auftraggeber.getId().getValue());
        resource.setName(auftraggeber.getName().getValue());
        resource.setTyp(auftraggeber.getTyp().getValue());
        return resource;
    }

    private Link createLink(long id, String linkGroup) {
        return linkTo("http://mitarbeiter/" + id).withRel(linkGroup);
    }

}
