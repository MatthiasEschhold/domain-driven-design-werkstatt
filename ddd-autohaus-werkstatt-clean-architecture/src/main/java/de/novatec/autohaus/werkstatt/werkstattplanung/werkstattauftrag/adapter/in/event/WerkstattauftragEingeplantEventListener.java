package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.adapter.in.event;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.WerkstattauftragsstatusAendernCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.Werkstattauftragsstatus;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus.WerkstattauftragstatusEnum;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.usecase.in.WerkstattauftragCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.adapter.out.event.WerkstattauftragEingeplantEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WerkstattauftragEingeplantEventListener implements ApplicationListener<WerkstattauftragEingeplantEvent> {

    private final WerkstattauftragCommand werkstattauftragCommand;

    @Override
    public void onApplicationEvent(WerkstattauftragEingeplantEvent werkstattauftragEingeplantEvent) {
        werkstattauftragCommand.auftragsstatusAnendern(new WerkstattauftragsstatusAendernCommand(
                new Werkstattauftragsnummer(werkstattauftragEingeplantEvent.getWerkstattauftragsnummer()),
                new Werkstattauftragsstatus(WerkstattauftragstatusEnum.EINGEPLANT.getValue())));
    }
}
