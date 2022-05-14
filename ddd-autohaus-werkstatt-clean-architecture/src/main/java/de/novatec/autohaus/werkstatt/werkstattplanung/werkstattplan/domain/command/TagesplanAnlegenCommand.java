package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.WerkstattplanId;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

@Command
@Getter
public class TagesplanAnlegenCommand extends WerkstattplanBaseCommand {

    private final Tag tag;

    public TagesplanAnlegenCommand(WerkstattplanId werkstattplanId, Tag tag) {
        super(werkstattplanId);
        this.tag = tag;
    }
}
