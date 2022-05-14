package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.WerkstattplanId;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class TagesplanAnlegenCommand extends WerkstattplanBaseCommand {

    private final Tag tag;

    public TagesplanAnlegenCommand(WerkstattplanId werkstattplanId, Tag tag) {
        super(werkstattplanId);
        this.tag = tag;
    }
}
