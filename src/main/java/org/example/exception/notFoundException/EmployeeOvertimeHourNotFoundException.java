package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class EmployeeOvertimeHourNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified employee overtime hour is not found";

    public EmployeeOvertimeHourNotFoundException() {
        super(MESSAGE);
    }
}
