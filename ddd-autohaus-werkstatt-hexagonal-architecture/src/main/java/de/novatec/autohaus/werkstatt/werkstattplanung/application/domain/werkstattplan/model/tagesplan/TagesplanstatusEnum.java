package de.novatec.autohaus.werkstatt.werkstattplanung.application.domain.werkstattplan.model.tagesplan;

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
