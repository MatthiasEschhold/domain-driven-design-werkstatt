package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstatttermin;

import de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan.Tag;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TerminStartEndeFormat {

    public final static String value = "HH::mm";

    public static DateTimeFormatter FORMAT() {
        return DateTimeFormat.forPattern(value);
    }

    public static DateTime PARSE(Tag tag) {
        return DateTime.parse(tag.getValue(), TerminStartEndeFormat.FORMAT());
    }
}
