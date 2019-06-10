package com.rpg.exception;

/**
 * Exception to be thrown when played without creating a character.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class NoCharacterCreatedException extends Exception {

    private static final long serialVersionUID = -8512507181192238483L;

    public NoCharacterCreatedException(final String message) {
        super(message);
    }

    public NoCharacterCreatedException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
