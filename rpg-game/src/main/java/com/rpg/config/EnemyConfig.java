package com.rpg.config;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.rpg.constants.CharacterNavigation;
import com.rpg.constants.PlayerType;
import com.rpg.model.Enemy;

/**
 * Enemy configuration with different powers.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class EnemyConfig implements Serializable {

    private EnemyConfig() {
        //hides constructor.
    }

    /**
     * Creating set of enemies with different paramaters.
     *
     * @return enemies(Set of enemy)/
     * @since 1.0-SNAPSHOT.
     */
    public static Set<Enemy> createEnemies() {
        final Set<Enemy> enemies = new HashSet<>();
        enemies.add(buildEnemy("E0", "BLACK", "1", 10, 10, 0, CharacterNavigation.BATMAN));
        enemies.add(buildEnemy("E1", "BROWN", "1", 10, 20, 2, CharacterNavigation.DEFAULT));
        enemies.add(buildEnemy("E2", "BROWN", "1", 10, 50, 3, CharacterNavigation.SPIDERMAN));
        enemies.add(buildEnemy("E3", "BROWN", "1", 10, 70, 1, CharacterNavigation.HITMAN));
        enemies.add(buildEnemy("E4", "WHITE", "1", 10, 80, 4, CharacterNavigation.BLACK_PANTHER));
        enemies.add(buildEnemy("E5", "WHITE", "1", 10, 20, 5, CharacterNavigation.DEFAULT));
        enemies.add(buildEnemy("E6", "WHITE", "1", 10, 50, 9, CharacterNavigation.DEFAULT));
        enemies.add(buildEnemy("E7", "GREY", "1", 10, 30, 6, CharacterNavigation.DEFAULT));
        enemies.add(buildEnemy("E8", "GREY", "1", 10, 100, 8, CharacterNavigation.DEFAULT));
        enemies.add(buildEnemy("E9", "GREY", "1", 10, 100, 7, CharacterNavigation.DEFAULT));
        return enemies;
    }

    /**
     * Create an enemy with given parameters.
     *
     * @param characterName
     * @param hairColor
     * @param yourAge
     * @param numberOfPoints
     * @param health
     * @param playerPosition
     * @param characterNavigation
     * @return enemy
     * @since 1.0-SNAPSHOT
     */
    private static Enemy buildEnemy(final String characterName,
                                    String hairColor,
                                    String yourAge,
                                    Integer numberOfPoints,
                                    Integer health,
                                    Integer playerPosition,
                                    CharacterNavigation characterNavigation) {
        final Enemy enemy = new Enemy(true);
        enemy.setCharacterName(characterName);
        enemy.setYourAge(yourAge);
        enemy.setHairColor(hairColor);
        enemy.setNumberOfPoints(numberOfPoints);
        enemy.setPlayerPosition(playerPosition);
        enemy.setHealth(health);
        enemy.setCharacterNavigation(characterNavigation);
        enemy.setPlayerType(PlayerType.ENEMY);
        return enemy;
    }

}
