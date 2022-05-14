package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan.WerkstattplanId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class WerkstattplanBaseCommand {
    private final WerkstattplanId werkstattplanId;
}
