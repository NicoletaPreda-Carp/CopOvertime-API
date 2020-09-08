package org.example.exception.resorceExists;

import org.example.exception.CopOvertimeGenericException;

public class RankExistsException extends CopOvertimeGenericException {
    public static final String MESSAGE = "The rank with this ID already exists";

    public RankExistsException() {
        super(MESSAGE);
    }
}
