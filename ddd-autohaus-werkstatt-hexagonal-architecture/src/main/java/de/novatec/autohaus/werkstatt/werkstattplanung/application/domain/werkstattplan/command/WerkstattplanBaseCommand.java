package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan.WerkstattplanId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@RequiredArgsConstructor
@Getter
public abstract class WerkstattplanBaseCommand {
    private final WerkstattplanId werkstattplanId;
}
