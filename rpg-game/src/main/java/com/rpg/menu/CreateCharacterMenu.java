package com.rpg.menu;

import static com.rpg.utils.InputUtils.askQuestionAndReadInput;

import java.util.Map;

import com.rpg.constants.CharacterNavigation;
import com.rpg.constants.Messages;
import com.rpg.constants.PlayerType;
import com.rpg.model.BattleField;
import com.rpg.model.Coordinates;
import com.rpg.model.GameCharacter;
import com.rpg.model.QuestionsToAsk;
import com.rpg.utils.CoordinatesUtils;
import com.rpg.utils.PrintUtils;

/**
 * CreateCharacterMenu.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class CreateCharacterMenu extends Menu {

    /**
     * Gamecharacter.
     *
     */
    GameCharacter gameCharacter;

    /**
     * Battle field to adding game character,
     */
    BattleField battleField;

    public CreateCharacterMenu(final BattleField battleField) {
        gameCharacter = new GameCharacter();
        this.battleField = battleField;
    }

    /**
     * Ask player to submit about character details.
     *
     * @since 1.0-SNAPSHOT.
     */
    public void createGameCharacter() {
        final QuestionsToAsk questionsToAsk = Messages.questionsToPlayer();
        gameCharacter.setCharacterName(askQuestionAndReadInput(questionsToAsk.getNameQuestion(), String.class));
        gameCharacter.setYourAge(askQuestionAndReadInput(questionsToAsk.getAgeQuestion(), String.class));
        gameCharacter.setHairColor(askQuestionAndReadInput(questionsToAsk.getHairColorQuestion(), String.class));
        gameCharacter.setPlayerPosition(askQuestionAndReadInput(questionsToAsk.getPlayerPositionQuestion(), Integer.class));
        gameCharacter.setNumberOfPoints(askQuestionAndReadInput(questionsToAsk.getPointsQuestion(), Integer.class));
        final String navigation = askQuestionAndReadInput(questionsToAsk.getNavigationQuestion(), String.class);
        gameCharacter.setPlayerType(PlayerType.PLAYER);
        gameCharacter.setCharacterNavigation(CharacterNavigation.valueOf(navigation));

        Map<Coordinates, GameCharacter> coordinatesGameCharacterMap = battleField.getCoordinatesGameCharacterMap();
        Coordinates randomCoordinates = CoordinatesUtils.randomCoordinates(10);
        coordinatesGameCharacterMap.put(randomCoordinates, gameCharacter);

        PrintUtils.showMessage(Messages.PLAYER_CREATED_MESSAGE);
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public BattleField getBattleField() {
        return battleField;
    }
}
