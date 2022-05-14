package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource.AuftraggeberResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.web.resource.WerkstattauftragResource;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftrag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.Auftraggeber;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.AuftraggeberId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.AuftraggeberName;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftraggeber.AuftraggeberTyp;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
