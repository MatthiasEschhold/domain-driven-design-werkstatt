package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsposition;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Objects;

@ValueObject
@Getter
public class Auftragspositionnummer {
    private String value;

    public Auftragspositionnummer(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auftragspositionnummer that = (Auftragspositionnummer) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
