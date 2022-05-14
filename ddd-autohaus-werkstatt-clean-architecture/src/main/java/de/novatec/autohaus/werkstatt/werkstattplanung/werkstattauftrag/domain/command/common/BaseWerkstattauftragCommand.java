package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseWerkstattauftragCommand {
    private final Werkstattauftragsnummer werkstattauftragsnummer;
}
