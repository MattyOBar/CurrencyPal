package com.nashss.se.currencypalservice.exceptions;

/**
 * Exception to throw when a given currencyAbrv is not found in the database.
 */

public class CurrencyNotFoundException extends RuntimeException {

    /**
     * Exception with no message or cause.
     */

    public CurrencyNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message a descriptive message for this exception.
     */

    public CurrencyNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public CurrencyNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public CurrencyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
