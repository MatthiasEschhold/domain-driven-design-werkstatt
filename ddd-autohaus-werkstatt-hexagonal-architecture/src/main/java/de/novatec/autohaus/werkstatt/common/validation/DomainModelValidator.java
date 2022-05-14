package de.novatec.autohaus.werkstatt.common.validation;

import de.novatec.autohaus.werkstatt.common.exception.InvariantException;

import java.util.List;

public class DomainModelValidator {

    public static void checkIfValueObjectIsNull(Object object, String nameOfObject) {
        if (object == null) {
            throw new InvariantException(String.format("%s darf nicht null sein!", nameOfObject));
        }
    }

    public static void checkIfValueObjectIsBlank(String object, String nameOfObject) {
        if (object.isBlank()) {
            throw new InvariantException(String.format("%s darf nicht null sein!", nameOfObject));
        }
    }

    public static void checkIfValueObjectIsInAllowedValueRange(String object, List<String> allowedValues, String nameOfObject) {
        if (!allowedValues.contains(object)) {
            throw new InvariantException(String.format("%s ist nicht im erlaubten Wertebereich!", nameOfObject));
        }
    }
}
