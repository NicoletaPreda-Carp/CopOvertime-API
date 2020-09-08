package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class DepartmentEmployeeNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified departmentEmployee is not found";

    public DepartmentEmployeeNotFoundException() {
        super(MESSAGE);
    }
}
