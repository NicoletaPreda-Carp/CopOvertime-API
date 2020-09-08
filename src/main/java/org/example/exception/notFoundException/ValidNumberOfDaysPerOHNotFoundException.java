package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class ValidNumberOfDaysPerOHNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified valid number of days is not found";

    public ValidNumberOfDaysPerOHNotFoundException() {
        super(MESSAGE);
    }
}
