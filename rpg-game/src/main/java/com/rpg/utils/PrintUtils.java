package com.rpg.utils;

import java.io.PrintStream;

/**
 * Utils to deal with rendering.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@.
 */
public class PrintUtils {
    private static final PrintStream PRINT_STREAM = System.out; //TODO : it is auto-closable.
    private PrintUtils() {
        //hides constructor
    }

    /**
     * Sends message to CLI.
     *
     * @param message
     * @since 1.0-SNAPSHOT.
     */
    public static void showMessage(final String message) {
        PRINT_STREAM.println(message);
    }
}
