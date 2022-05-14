package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.command.common.BaseAuftragspositionCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.Auftragspositionnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattauftrag.model.auftragsposition.service.material.Material;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;
import org.jmolecules.architecture.onion.simplified.DomainRing;

import java.util.List;

@DomainRing
@Command
@Getter
public class AuftragspositionAktualisierenCommand extends BaseAuftragspositionCommand {

    private final List<Material> materialien;

    public AuftragspositionAktualisierenCommand(Werkstattauftragsnummer auftragsnummer,
                                                Auftragspositionnummer auftragspositionnummer,
                                                List<Material> materialien) {
        super(auftragsnummer, auftragspositionnummer);
        this.materialien = materialien;
    }
}
