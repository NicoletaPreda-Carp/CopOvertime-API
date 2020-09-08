package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class LegalDayOffExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The legal day off with this ID already exists";

    public LegalDayOffExistsException() {
        super(MESSAGE);
    }
}
