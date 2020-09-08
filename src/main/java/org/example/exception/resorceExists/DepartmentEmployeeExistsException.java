package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class DepartmentEmployeeExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The departmentEmployee with this ID already exists";

    public DepartmentEmployeeExistsException() {
        super(MESSAGE);
    }
}
