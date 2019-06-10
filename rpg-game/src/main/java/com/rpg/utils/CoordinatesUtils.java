package com.rpg.utils;

import com.rpg.model.Coordinates;

/**
 * Utils for dealing with coordinates.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class CoordinatesUtils {

    private CoordinatesUtils() {
            //hides constructor.
    }

    /**
     * Generates random coordinates.
     *
     * @param mapSize
     * @return coordinates.
     * @since 1.0-SNAPSHOT.
     */
    public static Coordinates randomCoordinates(int mapSize) {
        int randomX = IntUtils.generateRandomNumber(0, mapSize);
        int randomY = IntUtils.generateRandomNumber(0, mapSize);
        return new Coordinates(randomX, randomY);
    }

    /**
     * Verify whether it is valid or not.
     *
     * @param coordinates
     * @return boolean
     *
     * @since 1.0-SNAPSHOT.
     */
    public static boolean isValidCoordinates(final Coordinates coordinates) {
        return IntUtils.COORDINATE_NUMBER_RANGE.test(coordinates.getX()) &&
                IntUtils.COORDINATE_NUMBER_RANGE.test(coordinates.getY());
    }
}
