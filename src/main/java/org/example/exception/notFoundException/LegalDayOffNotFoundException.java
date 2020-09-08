package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class LegalDayOffNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified legal day off is not found";

    public LegalDayOffNotFoundException() {
        super(MESSAGE);
    }
}
