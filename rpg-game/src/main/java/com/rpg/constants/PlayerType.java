package com.rpg.constants;

/**
 * Enum for player.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public enum PlayerType {

    /**
     * Enemy with symbol 'E'
     */
    ENEMY("E"),

    /**
     * Enemy with symbol 'P'
     */
    PLAYER("P"),
    EMPTY(" ");

    String characterSymbol;

    PlayerType(String characterSymbol) {
        this.characterSymbol = characterSymbol;
    }

    public String getCharacterSymbol() {
        return characterSymbol;
    }

    public void setCharacterSymbol(String characterSymbol) {
        this.characterSymbol = characterSymbol;
    }
}
