package com.rpg.model;

/**
 * Builder to build the character related questions.
 *
 * @author vijaykumar.s
 */
public class QuestionsToAsk {

    /**
     * question for character name.
     */
    private final String nameQuestion;

    /**
     * question for character age.
     */
    private final String ageQuestion;

    /**
     * question for character hair color.
     */
    private final String hairColorQuestion;

    /**
     * question for points questions.
     */
    private final String pointsQuestion;

    /**
     * question for navigation.
     */
    private final String navigationQuestion;

    /**
     * question for character position.
     */
    private final String playerPositionQuestion;

    public QuestionsToAsk(final String theNameQuestion,
                          final String theAgeQuestion,
                          final String theHairColorQuestion,
                          final String thePointsQuestion,
                          final String theNavigationQuestion,
                          final String thePlayerPositionQuestion) {
        this.nameQuestion = theNameQuestion;
        this.ageQuestion = theAgeQuestion;
        this.hairColorQuestion = theHairColorQuestion;
        this.pointsQuestion = thePointsQuestion;
        this.navigationQuestion = theNavigationQuestion;
        this.playerPositionQuestion = thePlayerPositionQuestion;
    }

    public String getNameQuestion() {
        return nameQuestion;
    }

    public String getAgeQuestion() {
        return ageQuestion;
    }

    public String getHairColorQuestion() {
        return hairColorQuestion;
    }

    public String getPointsQuestion() {
        return pointsQuestion;
    }

    public String getNavigationQuestion() {
        return navigationQuestion;
    }

    public String getPlayerPositionQuestion() {
        return playerPositionQuestion;
    }

    public static QuestionsToAskBuilder builder() {
        return new QuestionsToAskBuilder();
    }

    public static final class QuestionsToAskBuilder {
        private String nameQuestion;
        private String ageQuestion;
        private String hairColorQuestion;
        private String pointsQuestion;
        private String navigationQuestion;
        private String playerPositionQuestion;

        private QuestionsToAskBuilder() {
        }

        public QuestionsToAskBuilder withNameQuestion(final String theNameQuestion) {
            this.nameQuestion = theNameQuestion;
            return this;
        }

        public QuestionsToAskBuilder withAgeQuestion(final String theAgeQuestion) {
            this.ageQuestion = theAgeQuestion;
            return this;
        }

        public QuestionsToAskBuilder withHairColorQuestion(final String theHairColorQuestion) {
            this.hairColorQuestion = theHairColorQuestion;
            return this;
        }

        public QuestionsToAskBuilder withPointsQuestion(String thePointsQuestion) {
            this.pointsQuestion = thePointsQuestion;
            return this;
        }

        public QuestionsToAskBuilder withNavigationQuestion(String theNavigationQuestion) {
            this.navigationQuestion = theNavigationQuestion;
            return this;
        }

        public QuestionsToAskBuilder withPlayerPositionQuestion(final String thePlayerPositionQuestion) {
            this.playerPositionQuestion = thePlayerPositionQuestion;
            return this;
        }


        public QuestionsToAsk build() {
            return new QuestionsToAsk(nameQuestion,
                    ageQuestion,
                    hairColorQuestion,
                    pointsQuestion,
                    navigationQuestion,
                    playerPositionQuestion);
        }
    }
}
