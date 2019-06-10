package com.rpg.menu;

import static com.rpg.utils.PrintUtils.showMessage;

import java.util.Map;

import com.rpg.constants.Messages;
import com.rpg.constants.PlayerType;
import com.rpg.engine.GameEngine;
import com.rpg.engine.GameLauncher;
import com.rpg.exception.EnemyExistsException;
import com.rpg.exception.InvalidCoordinatesException;
import com.rpg.exception.NoCharacterCreatedException;
import com.rpg.model.BattleField;
import com.rpg.model.Coordinates;
import com.rpg.model.GameCharacter;
import com.rpg.utils.BattleViewBuilder;

/**
 * Explore menu to get explored.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class ExploreMenu extends Menu {

    /**
     * Battle field.
     */
    BattleField battleField;
    /**
     * Coordinates pertaining to the character.
     */
    Coordinates playerCoordinates;
    /**
     * GameLauncher.
     */
    GameLauncher gameLauncher;
    /**
     * Fight menu.
     */
    Menu fightMenu;

    public ExploreMenu(final GameLauncher gameLauncher, final BattleField battleField) {
        this.menuItems.put(0, "0 - Turn right");
        this.menuItems.put(1, "1 - Turn left");
        this.menuItems.put(2, "2 - Move forward");
        this.menuItems.put(3, "3 - Move backward");
        this.menuItems.put(4, "4 - Character Info");
        this.menuItems.put(5, "5 - Diagonal DownRight");
        this.menuItems.put(6, "6 - Diagonal UpRight");
        this.menuItems.put(7, "7 - Diagonal UpLeft");
        this.menuItems.put(8, "8 - Diagonal DownLeft");
        this.menuItems.put(10, "10 - Show BattleField");
        this.battleField = battleField;
        this.gameLauncher = gameLauncher;
        this.fightMenu = gameLauncher.getFightMenu();
    }

    /**
     * explore with player choice.
     *
     * @since 1.0-SNAPSHOT.
     */
    public void explore() {
        final BattleViewBuilder battleViewBuilder = new BattleViewBuilder(battleField);
        while (getMenuChoice() != 11) {
            menuAction();
            try {
                identifyPlayerCoordinatesAndPlayer(battleField.getCoordinatesGameCharacterMap()); //TODO : is this right place to implement?
                switch (getMenuChoice()) {
                    case 0:
                        GameEngine.moveRight(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 1:
                        GameEngine.moveLeft(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 2:
                        GameEngine.moveUp(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 3:
                        GameEngine.moveDown(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 4:
                        showGameCharacterInfo();
                        break;
                    case 5:
                        GameEngine.moveDiagonalUpRight(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 6:
                        GameEngine.moveDiagonalUpLeft(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 7:
                        GameEngine.moveDiagonalDownLeft(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 8:
                        GameEngine.moveDiagonalDownRight(battleField.getCoordinatesGameCharacterMap(), getPlayerCoordinates());
                        break;
                    case 9:
                        getGameLauncher().startNewGame();
                        break;
                    case 10:
                        battleViewBuilder.buildView();
                        battleViewBuilder.showView();
                        break;
                    default:
                        showMessage(Messages.INVALID_INPUT_CHOICE_MESSAGE);
                        break;
                }
            } catch (NoCharacterCreatedException e) {
                showMessage("Warning : " + e);
                getGameLauncher().startNewGame();
            } catch (InvalidCoordinatesException e) {
                showMessage("Warning : " + e);
            } catch (EnemyExistsException e) {
                showMessage("Warning : " + e);
                FightMenu fightMenu = (FightMenu) gameLauncher.getFightMenu();
                fightMenu.fight(this, battleField, getPlayerCoordinates(), e.getEnemyCoordinates());
            }
            battleViewBuilder.buildView();
            battleViewBuilder.showView();
        }
    }

    /**
     * Displays the character information.
     *
     * @throws NoCharacterCreatedException
     * @since 1.0-SNAPSHOT.
     */
    private void showGameCharacterInfo() throws NoCharacterCreatedException {
        GameCharacter gameCharacter = battleField.getCoordinatesGameCharacterMap().get(getPlayerCoordinates());
        if (gameCharacter != null) {
            showMessage(gameCharacter.toString());
        } else {
            throw new NoCharacterCreatedException(Messages.NO_CHARACTER_CREATED_EXCEPTION_MESSAGE);
        }
    }

    /**
     * Identifies the player coordinater and the game character.
     *
     * @param coordinatesGameCharacterMap
     * @throws NoCharacterCreatedException
     * @since 1.0-SNAPSHOT.
     */
    private void identifyPlayerCoordinatesAndPlayer(final Map<Coordinates, GameCharacter> coordinatesGameCharacterMap)
            throws NoCharacterCreatedException {
        determinePlayerCoordintates(coordinatesGameCharacterMap);
        if (coordinatesGameCharacterMap.get(getPlayerCoordinates()) == null) {
            throw new NoCharacterCreatedException(Messages.NO_CHARACTER_CREATED_EXCEPTION_MESSAGE);
        }
    }

    /**
     * Determines the player coordinates.
     *
     * @param gameCharacterMap
     * @since 1.0-SNAPSHOT.
     */
    private void determinePlayerCoordintates(final Map<Coordinates, GameCharacter> gameCharacterMap) {
        for (Map.Entry<Coordinates, GameCharacter> coordinatesGameCharacterEntry : gameCharacterMap.entrySet()) {
            if (coordinatesGameCharacterEntry.getValue() != null &&
                    PlayerType.PLAYER == coordinatesGameCharacterEntry.getValue().getPlayerType()) {
                this.playerCoordinates = coordinatesGameCharacterEntry.getKey();
            }
        }
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public GameLauncher getGameLauncher() {
        return gameLauncher;
    }

    public void setGameLauncher(GameLauncher gameLauncher) {
        this.gameLauncher = gameLauncher;
    }

    public Coordinates getPlayerCoordinates() {
        return playerCoordinates;
    }

    public void setPlayerCoordinates(Coordinates playerCoordinates) {
        this.playerCoordinates = playerCoordinates;
    }
}
