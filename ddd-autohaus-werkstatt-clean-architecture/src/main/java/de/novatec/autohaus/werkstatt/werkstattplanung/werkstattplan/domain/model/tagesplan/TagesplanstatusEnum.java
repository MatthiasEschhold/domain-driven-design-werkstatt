package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.tagesplan;

public enum TagesplanstatusEnum {
    AKTIV("AKTIV"), VERGANGEN("VERGANGEN");

    String value;

    TagesplanstatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
