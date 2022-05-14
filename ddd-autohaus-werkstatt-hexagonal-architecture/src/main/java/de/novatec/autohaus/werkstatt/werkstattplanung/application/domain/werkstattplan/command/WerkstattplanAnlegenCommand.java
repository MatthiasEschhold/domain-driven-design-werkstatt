package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.command;

import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

@DomainRing
@Command
@Getter
public class WerkstattplanAnlegenCommand {

}
