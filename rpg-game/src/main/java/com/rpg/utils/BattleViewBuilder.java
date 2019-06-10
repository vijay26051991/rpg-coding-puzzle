package com.rpg.utils;

import com.rpg.model.BattleField;
import com.rpg.model.Coordinates;
import com.rpg.model.GameCharacter;

/**
 * Builds the view for battle field and displays the same.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class BattleViewBuilder implements ViewBuilder {

    /**
     * Battle field
     */
    BattleField battleField;

    /**
     * Battle field as string for display purpose.
     */
    String battleAsString;

    public BattleViewBuilder(BattleField battleField) {

        this.battleField = battleField;
    }


    /**
     * Creating horizantal borders.
     *
     * @param stringBuilder
     * @param colsNumber
     * @since 1.0-SNAPSHOT
     */
    public void buildBorders(StringBuilder stringBuilder, int colsNumber) {
        stringBuilder.append("     ");
        for (int i = 1; i <= colsNumber; i++) {
            stringBuilder.append("  _  ");
        }
    }

    @Override
    public void buildView() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        buildBorders(stringBuilder, 10);
        stringBuilder.append("\n");
        for (int x = 0; x < 10; x++) {
            stringBuilder.append("  |  ");
            for (int y = 0; y < 10; y++) {
                GameCharacter gameCharacter = battleField.getCoordinatesGameCharacterMap().get(new Coordinates(x, y));
                if (gameCharacter != null) {
                    stringBuilder.append("  ");
                    stringBuilder.append(gameCharacter.getCharacterName());
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append("  *  ");
                }
            }
            stringBuilder.append("  |  ");
            stringBuilder.append("\n");
        }
        buildBorders(stringBuilder, 10);
        stringBuilder.append("\n");
        battleAsString = stringBuilder.toString();
    }

    @Override
    public void showView() {
        PrintUtils.showMessage(battleAsString);
    }

    public String getBattleAsString() {
        return battleAsString;
    }

    public void setBattleAsString(String battleAsString) {
        this.battleAsString = battleAsString;
    }
}
