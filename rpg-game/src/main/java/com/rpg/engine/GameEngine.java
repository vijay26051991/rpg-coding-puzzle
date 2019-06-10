package com.rpg.engine;

import java.util.Map;

import com.rpg.constants.CharacterNavigation;
import com.rpg.constants.CommonConstants;
import com.rpg.constants.Messages;
import com.rpg.constants.PlayerType;
import com.rpg.exception.EnemyExistsException;
import com.rpg.exception.InvalidCoordinatesException;
import com.rpg.model.Coordinates;
import com.rpg.model.Enemy;
import com.rpg.model.GameCharacter;
import com.rpg.utils.CoordinatesUtils;

/**
 * Engine class for all game actions.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class GameEngine {

    public GameEngine() {
    }

    /**
     * Based on logic, verify whether player can kill enemy.
     *
     * @param player
     * @param enemy
     * @return boolean
     */
    public static boolean fight(final GameCharacter player, final Enemy enemy) {
        //TODO: Determine the outcome of the fight based on player vs. enemy strength and a random element
        return player.getHealth() > enemy.getHealth() && player.getNumberOfPoints() > enemy.getNumberOfPoints();
    }

    public static int tallyBattleResults() {
        //TODO: Return the experience, etc. for winning the battle (to be added to the player's experience) - no reward or penalty for losing
        return 0;
    }

    /**
     * Travel the character to Up.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    public static void moveUp(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        final GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.up(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.UP));
        } else {
            newCoordinates = currentCoordinates.up();
        }

        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }

    /**
     * Travel the character to down.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     */
    public static void moveDown(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.down(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.DOWN));
        } else {
            newCoordinates = currentCoordinates.down();
        }
        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }


    /**
     * 1. Target coordinates contains enemy, throw an exception,
     * 2. Verify the coordinates. If it is valid, then place character into that.
     * 3. Else, throw invalidCooridinateException.
     *
     * @param coordinatesGameCharacterMap
     * @param gameCharacter
     * @param currentCoordinates
     * @param newPlayerCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    private static void verifyCoordinatesAndPlaceGameCharacter(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap,
                                                               final GameCharacter gameCharacter,
                                                               final Coordinates currentCoordinates,
                                                               final Coordinates newPlayerCoordinates) throws InvalidCoordinatesException, EnemyExistsException {

        //Check if enemy exists.
        if (isEnemyThere(coordinatesGameCharacterMap.get(newPlayerCoordinates))) {
            final EnemyExistsException enemyExistsException = new EnemyExistsException(Messages.ENEMY_EXISTS_MESSAGE);
            enemyExistsException.setEnemyCoordinates(newPlayerCoordinates);
            throw enemyExistsException;
        }

        //Check if it is a valid cooridnates.
        if (CoordinatesUtils.isValidCoordinates(newPlayerCoordinates)) {
            coordinatesGameCharacterMap.put(newPlayerCoordinates, gameCharacter);
            coordinatesGameCharacterMap.put(currentCoordinates, null);
        } else {
            throw new InvalidCoordinatesException(Messages.INVALID_COORIDNATES_MOVE_MESSAGE);
        }
    }


    /**
     * Travel the character to left.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    public static void moveLeft(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        final GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.left(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.LEFT));
        } else {
            newCoordinates = currentCoordinates.left();
        }

        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }

    /**
     * Travel the character to Right.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    public static void moveRight(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.right(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.RIGHT));
        } else {
            newCoordinates = currentCoordinates.right();
        }

        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }

    /**
     * Travel the character to diagonalUpRight, if it has jumps.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    public static void moveDiagonalUpRight(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        final GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.diagonalUpRight(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.DIAGONAL_UP_RIGHT));
        } else {
            newCoordinates = currentCoordinates.diagonalUpRight();
        }

        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }

    /**
     * Travel the character to diagonalUpLeft, if it has jumps.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    public static void moveDiagonalUpLeft(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        final GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.diagonalUpLeft(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.DIAGONAL_UP_LEFT));
        } else {
            newCoordinates = currentCoordinates.diagonalUpLeft();
        }

        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }

    /**
     * Travel the character to diagonalDownLeft, if it has jumps.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    public static void moveDiagonalDownLeft(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        final GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.diagonalDownLeft(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.DIAGONAL_DOWN_LEFT));
        } else {
            newCoordinates = currentCoordinates.diagonalDownLeft();
        }

        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }

    /**
     * Travel the character to diagonalDownRight, if it has jumps.
     *
     * @param coordinatesGameCharacterMap
     * @param currentCoordinates
     * @throws InvalidCoordinatesException
     * @throws EnemyExistsException
     * @since 1.0-SNAPSHOT.
     */
    public static void moveDiagonalDownRight(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap, final Coordinates currentCoordinates) throws InvalidCoordinatesException, EnemyExistsException {
        GameCharacter gameCharacter = coordinatesGameCharacterMap.get(currentCoordinates);
        Coordinates newCoordinates;
        if (!(CharacterNavigation.DEFAULT == gameCharacter.getCharacterNavigation())) {
            newCoordinates = currentCoordinates.diagonalDownRight(getJump(gameCharacter.getCharacterNavigation(), CommonConstants.DIAGONAL_DOWN_RIGHT));
        } else {
            newCoordinates = currentCoordinates.diagonalDownRight();
        }

        verifyCoordinatesAndPlaceGameCharacter(coordinatesGameCharacterMap, gameCharacter, currentCoordinates, newCoordinates);
    }

    /**
     * Get the jumps from the navigation.
     *
     * @param characterNavigation
     * @param direction
     * @return int.
     * @since 1.0-SNAPSHOT.
     */
    private static int getJump(final CharacterNavigation characterNavigation, String direction) {
        return (int) characterNavigation.getNavigation().getNavigationMap().get(direction);

    }

    /**
     * Verify the coordinates have enemy.
     *
     * @param gameCharacter
     * @return boolean
     * @since 1.0-SNAPSHOT.
     */
    private static boolean isEnemyThere(final GameCharacter gameCharacter) {
        return gameCharacter != null
                && PlayerType.ENEMY == gameCharacter.getPlayerType();
    }

}
