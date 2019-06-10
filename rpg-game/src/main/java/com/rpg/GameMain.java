package com.rpg;

import com.rpg.constants.Messages;
import com.rpg.engine.GameLauncher;
import com.rpg.engine.GameLoader;
import com.rpg.menu.MainMenu;
import com.rpg.menu.Menu;
import com.rpg.utils.PrintUtils;

public class GameMain {

    /**
     * The main method should start up the menu system and keep the program running until 'Exit' is chosen.
     */
    public static void main(String[] args) {

        Menu menu = new MainMenu();
        menu.menuAction();
        switch (menu.getMenuChoice()) {
            case 0:
                break;
            case 1:
                new GameLauncher(menu).startNewGame();
            case 2:
                new GameLoader().loadSavedGame();
            case 4:
                System.exit(1);
            default:
                PrintUtils.showMessage(Messages.INVALID_INPUT_CHOICE_MESSAGE);
        }
    }
}
