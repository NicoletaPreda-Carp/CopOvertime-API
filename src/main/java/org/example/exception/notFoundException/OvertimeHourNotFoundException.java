package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class OvertimeHourNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified overtime hour is not found";

    public OvertimeHourNotFoundException() {
        super(MESSAGE);
    }
}
