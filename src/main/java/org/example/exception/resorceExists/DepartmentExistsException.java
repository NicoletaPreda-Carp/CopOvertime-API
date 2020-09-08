package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class DepartmentExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The department with this ID already exists";

    public DepartmentExistsException() {
        super(MESSAGE);
    }
}
