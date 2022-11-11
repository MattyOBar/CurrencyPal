package com.nashss.se.currencypalservice.exceptions;

public class CustomerNotFound extends RuntimeException {
    /**
     * Exception with no message or cause.
     */
    public CustomerNotFound() {
        super();
    }
    /**
     * Exception with a message, but no cause
     * @param message a descriptive message for this exception.
     */

    public CustomerNotFound(String message) {
        super(message);
    }
    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public CustomerNotFound(Throwable cause) {
        super(cause);
    }
    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public CustomerNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
