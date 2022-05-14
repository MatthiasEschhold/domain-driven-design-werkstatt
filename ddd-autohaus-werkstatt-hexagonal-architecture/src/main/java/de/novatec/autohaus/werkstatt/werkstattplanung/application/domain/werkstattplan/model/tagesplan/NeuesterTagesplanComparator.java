package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan;

import org.joda.time.DateTime;

import java.util.Comparator;

public class NeuesterTagesplanComparator implements Comparator<Tagesplan> {

    @Override
    public int compare(Tagesplan tagpesplan1, Tagesplan tagesplan2) {
        DateTime tag1 = TagFormat.PARSE(tagpesplan1.getTag());
        DateTime tag2 = TagFormat.PARSE(tagesplan2.getTag());
        if (tag1.isAfter(tag2)) {
            return 1;
        } else if (tag1.isBefore(tag2)) {
            return -1;
        } else {
            return 0;
        }
    }

}
