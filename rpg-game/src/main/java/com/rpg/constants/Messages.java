package com.rpg.constants;

import com.rpg.model.QuestionsToAsk;

/**
 * Messages to be rendered into the CLI.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public interface Messages {

    String WHAT_S_YOUR_NAME = "What's your name?";
    String WHAT_S_YOUR_CHARACTER_NAME = "What's your character name? (Could be two letters)";
    String WHAT_S_YOUR_AGE = "What's your character age?";
    String WHAT_S_YOUR_HAIR_COLOR = "What's your hair color?";
    String WHAT_S_YOUR_POINTS = "What's your points?";
    String PLEASE_SET_POSITION = "Please set character position? (Just set 10 for now)";
    String PLEASE_SET_NAVIGATION = "Please set navigation? (Not sure, set as DEFAULT)";

    String PLAYER_CREATED_MESSAGE = "Player added and placed successfully into battle";

    String NO_CHARACTER_CREATED_EXCEPTION_MESSAGE = "No character created for the battle. Please create the character with the given menu!";
    String INVALID_INPUT_CHOICE_MESSAGE = "Your input does not match with the given choice!";
    String INVALID_COORIDNATES_MOVE_MESSAGE = "You cannot move as you're trying to go out of battle!";
    String ENEMY_EXISTS_MESSAGE = "Enemy exists, you have fight menu now in your front!";
    String RETREAT_MESSAGE = "Hey, I am retreating for this battle!";

    String ENEMY_ATTACKED_MESSAGE = "Target enemy attacked :). Keep going!";
    String GAME_SAVE_SUCCESS = "The object is successfully written into a file.";
    String GAME_SAVE_FAILURE = "The object is not successfully written into a file.";

    /**
     * Creates QuestionsToask Object
     *
     * @return questionsToAsk
     * @since 1.0-SNAPSHOT.
     */
    static QuestionsToAsk questionsToPlayer() {
        return QuestionsToAsk.builder()
                .withNameQuestion(WHAT_S_YOUR_CHARACTER_NAME)
                .withAgeQuestion(WHAT_S_YOUR_AGE)
                .withHairColorQuestion(WHAT_S_YOUR_HAIR_COLOR)
                .withPointsQuestion(WHAT_S_YOUR_POINTS)
                .withPlayerPositionQuestion(PLEASE_SET_POSITION)
                .withNavigationQuestion(PLEASE_SET_NAVIGATION)
                .build();
    }

}
