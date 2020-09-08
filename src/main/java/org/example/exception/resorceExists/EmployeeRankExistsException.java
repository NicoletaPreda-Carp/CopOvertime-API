package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class EmployeeRankExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The employee rank with this ID already exists";

    public EmployeeRankExistsException() {
        super(MESSAGE);
    }
}
