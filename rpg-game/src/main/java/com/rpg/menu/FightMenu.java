package com.rpg.menu;

import java.util.Map;

import com.rpg.constants.Messages;
import com.rpg.engine.GameEngine;
import com.rpg.engine.GameLauncher;
import com.rpg.model.BattleField;
import com.rpg.model.Coordinates;
import com.rpg.model.Enemy;
import com.rpg.model.GameCharacter;
import com.rpg.utils.PrintUtils;

/**
 * Fight menu when player likes to fight.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class FightMenu extends Menu {

    /**
     * Game launcher.
     */
    GameLauncher gameLauncher;

    public FightMenu(GameLauncher gameLauncher) {
        this.menuItems.put(1, "1 - Fight!");
        this.menuItems.put(2, "2 - Retreat");
        this.menuItems.put(3, "3 - Main menu");
        this.gameLauncher = gameLauncher;
    }

    /**
     * Fight with the enemy.
     *
     * @param exploreMenu
     * @param battleField
     * @param playerCoordinates
     * @param enemyCoordinates
     * @since 1.0.SNAPSHOT.
     */
    public void fight(final ExploreMenu exploreMenu,
                      final BattleField battleField,
                      final Coordinates playerCoordinates,
                      final Coordinates enemyCoordinates) {

        while (getMenuChoice() != 11) {
            menuAction();
            switch (getMenuChoice()) {
                case 1:
                    final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap = battleField.getCoordinatesGameCharacterMap();
                    GameCharacter gameCharacter = coordinatesGameCharacterMap.get(playerCoordinates);
                    Enemy enemy = (Enemy) coordinatesGameCharacterMap.get(enemyCoordinates);
                    boolean isAttacked = GameEngine.fight(gameCharacter, enemy);
                    if (isAttacked) {
                        coordinatesGameCharacterMap.put(enemyCoordinates, stealHealthAndPointsFromEnemy(gameCharacter, enemy));
                        coordinatesGameCharacterMap.put(playerCoordinates, null);
                        PrintUtils.showMessage(Messages.ENEMY_ATTACKED_MESSAGE);
                    }
                    break;
                case 2:
                    PrintUtils.showMessage(Messages.RETREAT_MESSAGE);
                    break;
                case 3:
                    getGameLauncher().startNewGame();
                    break;
                case 9:
                    exploreMenu.explore();
                    break;
                default:
                    PrintUtils.showMessage(Messages.INVALID_INPUT_CHOICE_MESSAGE);

            }
        }
    }

    /**
     * adds enemies health and points to the character.
     *
     * @param gameCharacter
     * @param enemy
     * @return gameCharacter.
     * @since 1.0-SNAPSHOT.
     */
    private GameCharacter stealHealthAndPointsFromEnemy(final GameCharacter gameCharacter, final Enemy enemy) {
        gameCharacter.setHealth(gameCharacter.getHealth() + enemy.getHealth());
        gameCharacter.setNumberOfPoints(gameCharacter.getNumberOfPoints() + enemy.getNumberOfPoints());
        return gameCharacter;
    }

    public GameLauncher getGameLauncher() {
        return gameLauncher;
    }
}
