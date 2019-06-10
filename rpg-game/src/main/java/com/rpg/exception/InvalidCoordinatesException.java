package com.rpg.exception;

/**
 * Exception to be thrown when the player is trying to go out of battle field.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class InvalidCoordinatesException extends Exception {
    public InvalidCoordinatesException(final String message) {
        super(message);
    }

    public InvalidCoordinatesException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
