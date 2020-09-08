package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class EmployeeRankNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified employee rank is not found";

    public EmployeeRankNotFoundException() {
        super(MESSAGE);
    }
}
