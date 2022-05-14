package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.command.common.BaseAuftragspositionCommand;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.Werkstattauftragsnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.Auftragspositionnummer;
import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition.service.material.Material;
import lombok.Getter;
import org.jmolecules.architecture.cqrs.annotation.Command;

import java.util.List;

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
