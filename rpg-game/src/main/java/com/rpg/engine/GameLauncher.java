package com.rpg.engine;

import com.rpg.constants.Messages;
import com.rpg.menu.*;
import com.rpg.model.BattleField;
import com.rpg.utils.InputUtils;
import com.rpg.utils.PrintUtils;

/**
 * Starts a new game with main menus.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class GameLauncher {

    /**
     * default menu
     */
    Menu menu;
    /**
     * new game menu.
     */
    Menu newGameMenu;
    /**
     * fight menu.
     */
    Menu fightMenu;
    /**
     * battle field
     */
    BattleField battleField;

    /**
     * file name.
     */
    String playerNameAsfileName;

    public GameLauncher(Menu menu) {
        this.menu = menu;
        this.newGameMenu = new NewGameMenu();
        this.fightMenu = new FightMenu(this);
        this.battleField = initBattleField();
        playerNameAsfileName = InputUtils.askQuestionAndReadInput(Messages.WHAT_S_YOUR_NAME, String.class);
    }

    private BattleField initBattleField() {
        BattleField battleField = new BattleField();
        return battleField;

    }

    /**
     * Starts a new game with user input choice.
     *
     * @since 1.0-SNAPSHOT.
     */
    public void startNewGame() {
        PrintUtils.showMessage("\n\n\n");
        Integer menuChoice = newGameMenu.getMenuChoice();
        while (menuChoice != 9) {
            newGameMenu.menuAction();
            switch (newGameMenu.getMenuChoice()) {
                case 1:
                    CreateCharacterMenu createCharacterMenu = new CreateCharacterMenu(battleField);
                    createCharacterMenu.createGameCharacter();
                    this.battleField = createCharacterMenu.getBattleField();
                    break;
                case 2:
                    new ExploreMenu(this, battleField).explore();
                    break;
                case 3:
                    final String message = new SaveGameMenu(battleField, getPlayerNameAsfileName()).saveGame() == 1 ? Messages.GAME_SAVE_SUCCESS : Messages.GAME_SAVE_FAILURE;
                    PrintUtils.showMessage(message);
                    break;
                case 5:
                    menu.menuAction();
                    break;
                case 8:
                    System.exit(1);
                    break;
                default:
                    PrintUtils.showMessage(Messages.INVALID_INPUT_CHOICE_MESSAGE);
                    break;
            }
        }
    }

    public Menu getFightMenu() {
        return fightMenu;
    }

    public String getPlayerNameAsfileName() {
        return playerNameAsfileName;
    }
}
