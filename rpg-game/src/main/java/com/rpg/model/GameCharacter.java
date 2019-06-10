package com.rpg.model;

import java.io.Serializable;

import com.rpg.constants.CharacterNavigation;
import com.rpg.constants.PlayerType;

/**
 * Model for game character.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@.
 */
public class GameCharacter implements Serializable {

    private static final long serialVersionUID = -438609510463380423L;

    private String characterName = "";
    private String hairColor;
    private String yourAge;
    private Integer numberOfPoints;
    private Integer health = 100;
    private String noOfResourcesTaken;
    private CharacterNavigation characterNavigation;
    private Integer playerPosition;
    private PlayerType playerType;

    //TODO: To be included in improvements.
    private String level;
    private String noOfLevelsPlayed;
    private Integer characterLevel = 1;
    private Double characterExperience = 0D; //As the character gains experience exponentially, the player level goes up


    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getNoOfResourcesTaken() {
        return noOfResourcesTaken;
    }

    public void setNoOfResourcesTaken(String noOfResourcesTaken) {

        this.noOfResourcesTaken = noOfResourcesTaken;
    }

    public Integer getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    //TODO: Getters and setters, helper methods
    //TODO : override equals and hashcode methods.

    public String getYourAge() {
        return yourAge;
    }

    public void setYourAge(String yourAge) {
        this.yourAge = yourAge;
    }

    public Integer getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Integer playerPosition) {
        this.playerPosition = playerPosition;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public CharacterNavigation getCharacterNavigation() {
        return characterNavigation;
    }

    public void setCharacterNavigation(CharacterNavigation characterNavigation) {
        this.characterNavigation = characterNavigation;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append("---------------------------------------------")
                .append("\n|\t")
                .append("\n|\tName:\t\t" + getCharacterName())
                .append("\n|\tAge\t\t" + getYourAge())
                .append("\n|\tNavigation\t\t" + getCharacterNavigation())
                .append("\n|\tHairColor\t\t" + getHairColor())
                .append("\n|\tHealth\t\t" + getHealth())
                .append("\n|\tPoints\t\t" + getNumberOfPoints())
                .append("\n|\tType\t\t" + getPlayerType().name())
                .append("\n")
                .append("---------------------------------------------").toString();
    }
}
