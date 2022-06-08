package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.schedule;

import de.novatec.autohaus.werkstatt.jmolecules.InputAdapter;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in.RolloverTagesplan;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@InputAdapter
@Component
@RequiredArgsConstructor
public class RolloverTagesplanSchedule {

    private final RolloverTagesplan rolloverTagesplan;

    @Scheduled(cron = "0 0 23 * * *")
    public void rolloverTagesplan() {
        rolloverTagesplan.rolloverTagesplan();
    }
}
