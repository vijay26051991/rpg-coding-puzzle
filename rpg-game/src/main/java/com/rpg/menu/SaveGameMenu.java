package com.rpg.menu;

import com.rpg.model.BattleField;
import com.rpg.model.GameCharacter;
import com.rpg.utils.FileUtils;

/**
 * Save choice for the player.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class SaveGameMenu extends Menu {

    /**
     * file name for saving object.
     */
    private String fileName;

    /**
     * Battle field.
     */
    private BattleField battleField;

    public SaveGameMenu(final BattleField battleField, String fileName) {
        this.menuItems.put(0, "0 - Save game");
        this.menuItems.put(1, "1 - Resume game");

        this.fileName = fileName;
        this.battleField = battleField;
    }

    /**
     * saving object into a file.
     *
     * @return 1(success) or 0(failure).
     * @since 1.0-SNAPSHOT.
     */
    public int saveGame() {
        return FileUtils.writeObjectToFile(battleField, getFileName());
    }


    public GameCharacter resumeGame() {
        //TODO: Read a previous game file and load the state
        return new GameCharacter();
    }

    public String getFileName() {
        return fileName;
    }
}


