package com.nashss.se.currencypalservice.exceptions;

/**
 * Exception to throw when a given Transaction is not valid.
 */
public class TransactionNotValidException extends RuntimeException {

    private static final long serialVersionUID = 2993530266193793066L;

    /**
     * Exception with no message or cause.
     */
    public TransactionNotValidException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message a descriptive message for this exception.
     */
    public TransactionNotValidException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public TransactionNotValidException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public TransactionNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
