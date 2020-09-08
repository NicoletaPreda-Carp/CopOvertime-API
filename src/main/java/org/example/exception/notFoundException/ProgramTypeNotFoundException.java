package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class ProgramTypeNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified program type is not found";

    public ProgramTypeNotFoundException() {
        super(MESSAGE);
    }
}
