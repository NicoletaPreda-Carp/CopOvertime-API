package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class DepartmentNotFoundException extends CopOvertimeGenericException {

    public static final String MESSAGE = "The specified department is not found";

    public DepartmentNotFoundException() {
        super(MESSAGE);
    }

}
