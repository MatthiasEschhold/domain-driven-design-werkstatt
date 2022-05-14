package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TagFormat {

    public final static String value = "dd:MM:yyyy";

    public static DateTimeFormatter FORMAT() {
        return DateTimeFormat.forPattern(value);
    }

    public static DateTime PARSE(Tag tag) {
        return DateTime.parse(tag.getValue(), TagFormat.FORMAT());
    }
}
