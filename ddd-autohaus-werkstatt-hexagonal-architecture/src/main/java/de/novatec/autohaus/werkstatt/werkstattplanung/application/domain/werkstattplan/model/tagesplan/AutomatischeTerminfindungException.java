package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan;

import de.novatec.autohaus.werkstatt.jmolecules.DomainException;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
@DomainException
public class AutomatischeTerminfindungException extends RuntimeException {
    public AutomatischeTerminfindungException(String message) {
        super(message);
    }
}
