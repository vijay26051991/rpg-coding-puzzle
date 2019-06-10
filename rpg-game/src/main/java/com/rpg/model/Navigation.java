package com.rpg.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Navigation for the unique characters.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class Navigation {

    public Navigation(){}

    private Map navigationMap = new HashMap();

    public Navigation(final int left,
                      final int right,
                      final int up,
                      final int down,
                      final int diagonalUpLeft,
                      final int diagonalUpRight,
                      final int diagonalDownRight,
                      final int diagonalDownLeft) {
        navigationMap.put("left", left);
        navigationMap.put("right", right);
        navigationMap.put("up", up);
        navigationMap.put("down", down);
        navigationMap.put("diagonalUpLeft", diagonalUpLeft);
        navigationMap.put("diagonalUpRight", diagonalUpRight);
        navigationMap.put("diagonalDownRight", diagonalDownRight);
        navigationMap.put("diagonalDownLeft", diagonalDownLeft);
    }

    public Map getNavigationMap() {
        return navigationMap;
    }

}
