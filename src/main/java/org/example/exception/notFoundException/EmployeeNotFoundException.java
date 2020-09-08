package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class EmployeeNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified employee is not found";

    public EmployeeNotFoundException() {
        super(MESSAGE);
    }
}
