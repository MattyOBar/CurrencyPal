package com.nashss.se.currencypalservice.exceptions;

/**
 * Exception to throw when a given Customer is not found in the database.
 */
public class CustomerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -4693722530029468262L;

    /**
     * Exception with no message or cause.
     */
    public CustomerNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause
     * @param message a descriptive message for this exception.
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
