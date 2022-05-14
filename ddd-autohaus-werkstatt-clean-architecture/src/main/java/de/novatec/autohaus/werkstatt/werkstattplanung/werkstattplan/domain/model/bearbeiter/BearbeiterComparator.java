package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.bearbeiter;

import java.util.Comparator;

public class BearbeiterComparator implements Comparator<Bearbeiter> {

    @Override
    public int compare(Bearbeiter bearbeiter1, Bearbeiter bearbeiter2) {
        //Welcher Bearbeiter hat am meisten verfuegbare Zeit?
        return 1;
    }

}
