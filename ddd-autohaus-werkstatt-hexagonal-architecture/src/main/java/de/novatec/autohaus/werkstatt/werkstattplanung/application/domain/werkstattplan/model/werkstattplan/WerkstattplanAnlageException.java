package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstattplan;

import de.novatec.autohaus.werkstatt.jmolecules.DomainException;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
@DomainException
public class WerkstattplanAnlageException extends RuntimeException {
    public WerkstattplanAnlageException(String message) {
        super(message);
    }
}
