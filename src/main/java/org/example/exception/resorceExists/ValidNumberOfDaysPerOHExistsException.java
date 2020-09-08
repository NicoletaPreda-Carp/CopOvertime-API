package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class ValidNumberOfDaysPerOHExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The valid number of days per overtime hour with this ID already exists";

    public ValidNumberOfDaysPerOHExistsException() {
        super(MESSAGE);
    }
}
