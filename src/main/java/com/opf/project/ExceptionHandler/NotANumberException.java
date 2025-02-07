package com.opf.project.ExceptionHandler;

public class NotANumberException extends RuntimeException {

    public NotANumberException() {
        super();
    }

    public NotANumberException(String message) {
        super(message);
    }

    public NotANumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotANumberException(Throwable cause) {
        super(cause);

    }
}
