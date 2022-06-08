package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.in.event;

import de.novatec.autohaus.werkstatt.jmolecules.DomainEventListener;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.out.event.WerkstattauftragPlanbarEvent;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Zeitbedarf;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.command.WerkstattauftragPlanenCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter.BearbeiterId;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin.WerkstattauftragRef;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.usecase.in.WerkstattplanCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@DomainEventListener
@Component
@RequiredArgsConstructor
public class WerkstattauftragPlanbarEventListener implements ApplicationListener<WerkstattauftragPlanbarEvent> {

    private final WerkstattplanCommand werkstattplanCommand;

    @Override
    public void onApplicationEvent(WerkstattauftragPlanbarEvent werkstattauftragPlanbarEvent) {
        if (werkstattauftragPlanbarEvent.getBearbeiterRef() != null) {
            werkstattplanCommand.werkstattauftragPlanen(
                    new WerkstattauftragPlanenCommand(new WerkstattauftragRef(werkstattauftragPlanbarEvent.getWerkstattauftragsnummer()),
                            new Zeitbedarf(werkstattauftragPlanbarEvent.getZeitbedarf())));
        } else {
            werkstattplanCommand.werkstattauftragPlanen(
                    new WerkstattauftragPlanenCommand(new WerkstattauftragRef(werkstattauftragPlanbarEvent.getWerkstattauftragsnummer()),
                            new Zeitbedarf(werkstattauftragPlanbarEvent.getZeitbedarf()),
                            new BearbeiterId(werkstattauftragPlanbarEvent.getBearbeiterRef())));
        }

    }
}
