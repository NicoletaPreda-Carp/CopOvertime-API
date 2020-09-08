package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class DepartmentProgramNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified department program is not found";

    public DepartmentProgramNotFoundException() {
        super(MESSAGE);
    }
}
