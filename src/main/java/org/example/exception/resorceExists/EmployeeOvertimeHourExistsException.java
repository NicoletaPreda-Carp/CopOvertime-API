package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class EmployeeOvertimeHourExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The employee overtime hour with this ID already exists";

    public EmployeeOvertimeHourExistsException() {
        super(MESSAGE);
    }
}
