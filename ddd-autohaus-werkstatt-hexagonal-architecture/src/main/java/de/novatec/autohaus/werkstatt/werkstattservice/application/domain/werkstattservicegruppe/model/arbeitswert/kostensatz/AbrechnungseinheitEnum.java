package de.novatec.autohaus.werkstatt.werkstattservice.application.domain.werkstattservicegruppe.model.arbeitswert.kostensatz;

public enum AbrechnungseinheitEnum {
    FUENF_MINUTEN_TAKT("FUENF_MINUTEN_TAKT"),
    STUNDENTAKT("STUNDEN_TAKT");

    private String value;

    AbrechnungseinheitEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
