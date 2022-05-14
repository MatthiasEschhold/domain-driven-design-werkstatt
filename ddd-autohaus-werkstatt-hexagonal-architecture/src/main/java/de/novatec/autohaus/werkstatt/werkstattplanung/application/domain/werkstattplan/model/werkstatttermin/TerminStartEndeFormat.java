package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.werkstatttermin;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.jmolecules.DomainModelBehavior;
import org.jmolecules.architecture.onion.classical.DomainModelRing;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@DomainModelRing
@DomainModelBehavior
public class TerminStartEndeFormat {

    public final static String value = "HH::mm";

    public static DateTimeFormatter FORMAT() {
        return DateTimeFormat.forPattern(value);
    }

    public static DateTime PARSE(Tag tag) {
        return DateTime.parse(tag.getValue(), TerminStartEndeFormat.FORMAT());
    }
}
