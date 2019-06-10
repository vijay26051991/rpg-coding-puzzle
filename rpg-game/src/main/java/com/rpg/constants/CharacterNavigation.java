package com.rpg.constants;

import com.rpg.model.Navigation;

/**
 * Different characters associated with different navigations.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public enum CharacterNavigation {

    /**
     * Each move one at a time, diagional move is 3 at a time.
     */
    BATMAN(new Navigation(1, 1, 1, 1, 3, 3, 3, 3)),

    /**
     * Left and Right is two, diagional move is 0 at a time.
     */
    SPIDERMAN(new Navigation(2, 2, 1, 1, 0, 0, 0, 0)),

    /**
     * All directions are two, diagonal is 0
     */
    BLACK_PANTHER(new Navigation(2, 2, 2, 2, 0, 0, 0, 0)),

    /**
     * No diagonal. One move at a time.
     */
    DEFAULT(new Navigation(1, 1, 1, 1, 0, 0, 0, 0)),

    /**
     * 3 step for diagonal, 1 step for each move.
     */
    HITMAN(new Navigation(1, 1, 1, 1, 3, 3, 3, 3));

    private final Navigation navigation;

    CharacterNavigation(final Navigation theNavigation) {

        this.navigation = theNavigation;
    }

    public Navigation getNavigation() {
        return navigation;
    }
}
