package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.factory;

import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.Tag;
import de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan.TagFormat;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.jmolecules.ddd.annotation.Factory;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@DomainRing
@Factory
@Component
public class TagFactory {

    public Set<Tag> createHeutePlus2() {
        LocalDate date = LocalDate.now();
        Tag tag1 = new Tag(date.toString(TagFormat.FORMAT()));
        Tag tag2 = new Tag(date.plusDays(1).toString(TagFormat.FORMAT()));
        Tag tag3 = new Tag(date.plusDays(2).toString(TagFormat.FORMAT()));
        Set<Tag> tage = new HashSet<>();
        tage.add(tag1);
        tage.add(tag2);
        tage.add(tag3);
        return tage;
    }

    public Tag createNextDay(Tag tag) {
        LocalDate date = LocalDate.parse(tag.getValue());
        return new Tag(date.plusDays(1).toString(TagFormat.FORMAT()));
    }
}
