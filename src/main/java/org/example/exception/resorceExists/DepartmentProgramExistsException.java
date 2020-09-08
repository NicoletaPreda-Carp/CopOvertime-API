package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class DepartmentProgramExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The department program with this ID already exists";

    public DepartmentProgramExistsException() {
        super(MESSAGE);
    }
}
