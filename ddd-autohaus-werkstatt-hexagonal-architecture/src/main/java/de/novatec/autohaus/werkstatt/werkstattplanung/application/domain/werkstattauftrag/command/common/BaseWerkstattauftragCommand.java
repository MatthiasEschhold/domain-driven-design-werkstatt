package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseWerkstattauftragCommand {
    private final Werkstattauftragsnummer werkstattauftragsnummer;
}
