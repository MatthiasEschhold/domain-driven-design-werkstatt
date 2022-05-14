package de.novatec.autohaus.werkstatt.werkstattplanung.adapter.in.schedule;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.port.in.werkstattplan.TagesplanBatchCommand;
import de.novatec.autohaus.werkstatt.jmolecules.Batch;
import de.novatec.autohaus.werkstatt.jmolecules.InputAdapter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@InfrastructureRing
@InputAdapter
@Batch
@Component
@RequiredArgsConstructor
public class RolloverTagesplanSchedule {

    private final TagesplanBatchCommand tagesplanBatchCommand;

    @Scheduled(cron = "0 0 23 * * *")
    public void rolloverTagesplan() {
        tagesplanBatchCommand.neuenTagesplanHinzufuegen();
    }
}
