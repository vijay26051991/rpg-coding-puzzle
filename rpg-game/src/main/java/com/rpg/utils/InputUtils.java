package com.rpg.utils;

import static com.rpg.utils.PrintUtils.showMessage;

import java.util.Scanner;

import com.rpg.constants.CharacterNavigation;

public class InputUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtils() {
        //hides constructor
    }

    public static Integer readIntAsInput() {
        return SCANNER.nextInt();
    }

    public static String readStringAsInput() {
        return SCANNER.next();
    }

    public static  <T> T askQuestionAndReadInput(final String question, final Class<T> c) {
        showMessage(question);
        if (c == Integer.class) {
            return (T) readIntAsInput();
        } else if (c == String.class || c == CharacterNavigation.class) {
            return (T) readStringAsInput();
        }
        return null;
    }
}
