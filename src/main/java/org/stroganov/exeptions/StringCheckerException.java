package org.stroganov.exeptions;

public class StringCheckerException extends Exception{

    public StringCheckerException() {
    }

    public StringCheckerException(String message) {
        super(message);
    }

    public StringCheckerException(String message, Throwable cause) {
        super(message, cause);
    }
}
