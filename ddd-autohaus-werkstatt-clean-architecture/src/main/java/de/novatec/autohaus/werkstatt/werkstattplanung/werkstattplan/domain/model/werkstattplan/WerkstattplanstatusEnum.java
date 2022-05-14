package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattplan.domain.model.werkstattplan;

import lombok.Getter;

@Getter
public enum WerkstattplanstatusEnum {
    AKTIV("AKTIV"), ARCHIVIERT("ARCHIVIERT");

    private String value;

    WerkstattplanstatusEnum(String value) {
        this.value = value;
    }

}
