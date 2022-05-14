package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.bearbeiter;

import de.novatec.autohaus.werkstatt.jmolecules.DomainModelBehavior;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

import java.util.Comparator;

@DomainModelRing
@DomainModelBehavior
public class VerfuegbarsterBearbeiterComparator implements Comparator<Bearbeiter> {

    @Override
    public int compare(Bearbeiter bearbeiter1, Bearbeiter bearbeiter2) {
        //Welcher Bearbeiter hat am meisten verfuegbare Zeit?
        return 1;
    }

}
