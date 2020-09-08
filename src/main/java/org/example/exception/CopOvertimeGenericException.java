package org.example.exception;

public class CopOvertimeGenericException extends Exception {

    private static final String MESSAGE = "Generic CopOvertime ERROR";

    public CopOvertimeGenericException() {
        super(MESSAGE);
    }

    public CopOvertimeGenericException(String message) {
        super(message);
    }
}


