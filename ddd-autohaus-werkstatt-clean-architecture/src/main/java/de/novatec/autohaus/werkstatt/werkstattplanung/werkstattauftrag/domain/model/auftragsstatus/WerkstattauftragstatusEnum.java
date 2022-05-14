package de.novatec.autohaus.werkstatt.werkstattplanung.werkstattauftrag.domain.model.auftragsstatus;

public enum WerkstattauftragstatusEnum {
    ANGELEGT("ANGELEGT"),
    PLANBAR("PLANBAR"),
    GESTARTET("GESTARTET"),
    UNTERBROCHEN("UNTERBROCHEN"),
    FORTGESETZT("FORTGESETZT"),
    STORNIERT("STORNIERT"),
    GESCHLOSSEN("GESCHLOSSEN"),
    EINGEPLANT("EINGEPLANT");

    private String value;

    WerkstattauftragstatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
