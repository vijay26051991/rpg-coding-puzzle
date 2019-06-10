package com.rpg.exception;

import com.rpg.model.Coordinates;

/**
 * Exception to be thrown when player is trying to reach enemy coordinates.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@.
 */
public class EnemyExistsException extends Exception {

    Coordinates enemyCoordinates;

    public EnemyExistsException(final String message) {
        super(message);
    }

    public EnemyExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public Coordinates getEnemyCoordinates() {
        return enemyCoordinates;
    }

    public void setEnemyCoordinates(Coordinates enemyCoordinates) {
        this.enemyCoordinates = enemyCoordinates;
    }
}
