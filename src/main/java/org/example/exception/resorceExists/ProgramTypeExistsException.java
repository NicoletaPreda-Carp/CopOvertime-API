package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class ProgramTypeExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The program type with this ID already exists";

    public ProgramTypeExistsException() {
        super(MESSAGE);
    }
}
