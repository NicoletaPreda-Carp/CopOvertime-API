package org.example.exception.notFoundException;

import org.example.exception.CopOvertimeGenericException;

public class RankNotFoundException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The specified rank is not found";

    public RankNotFoundException() {
        super(MESSAGE);
    }
}
