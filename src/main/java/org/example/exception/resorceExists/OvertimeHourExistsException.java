package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class OvertimeHourExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The overtime hour with this ID already exists";

    public OvertimeHourExistsException() {
        super(MESSAGE);
    }
}
