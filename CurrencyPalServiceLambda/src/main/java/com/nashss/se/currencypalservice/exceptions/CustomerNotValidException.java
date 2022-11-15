package com.nashss.se.currencypalservice.exceptions;

/**
 * Exception to throw when a given Customer is not valid.
 */
public class CustomerNotValidException extends RuntimeException {

    private static final long serialVersionUID = -3378356824843884107L;

    /**
     * Exception with no message or cause.
     */
    public CustomerNotValidException() {
        super();
    }

    /**
     * Exception with a message, but no cause
     * @param message a descriptive message for this exception.
     */
    public CustomerNotValidException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public CustomerNotValidException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public CustomerNotValidException(String message, Throwable cause) {
        super(message, cause);
    }


}
