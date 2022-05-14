package de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan;

import de.novatec.autohaus.werkstatt.jmolecules.InputPort;

@InputPort
public interface TagesplanBatchCommand {
    void neuenTagesplanHinzufuegen();
}
