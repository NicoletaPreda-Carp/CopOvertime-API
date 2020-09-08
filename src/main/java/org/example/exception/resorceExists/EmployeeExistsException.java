package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class EmployeeExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The employee with this ID already exists";

    public EmployeeExistsException() {
        super(MESSAGE);
    }
}
