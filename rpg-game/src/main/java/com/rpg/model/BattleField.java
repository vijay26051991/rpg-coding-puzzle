package com.rpg.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.rpg.config.EnemyConfig;
import com.rpg.constants.CommonConstants;
import com.rpg.utils.CoordinatesUtils;
import com.rpg.utils.PropertyUtils;

/**
 * Model for battle field and it constructs the battle field with enemies.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class BattleField implements Serializable {

    private static final long serialVersionUID = 5603741868588004705L;

    /**
     * Coordinates and (Player or Enemy) mapping.
     */
    Map<Coordinates, GameCharacter> coordinatesGameCharacterMap;

    /**
     * Maximum size of x axis.
     */
    Integer maximumX;

    /**
     * Maximum size of y axis.
     */
    Integer maximumY;

    public BattleField() {
        coordinatesGameCharacterMap = new LinkedHashMap<>();
        maximumX = Integer.parseInt(PropertyUtils.getPropertyValue(CommonConstants.NO_OF_ROWS));
        maximumY = Integer.parseInt(PropertyUtils.getPropertyValue(CommonConstants.NO_OF_COLUMNS));
        initEmptyBattleField();
        placeEnemiesRandomly();
    }


    /**
     * Creates a empty battle field.
     *
     * @since 1.0-SNAPSHOT
     */
    private void initEmptyBattleField() {
        for (int x = 0; x < getMaximumX(); x++) {
            for (int y = 0; y < getMaximumY(); y++) {
                coordinatesGameCharacterMap.put(new Coordinates(x, y), null);
            }
        }
    }

    /**
     * Place the enemies randomly.
     *
     * @since 1.0-SNAPSHOT
     */
    private void placeEnemiesRandomly() {
        for (final Enemy enemy : EnemyConfig.createEnemies()) {
            final Coordinates randomCoordinates = CoordinatesUtils.randomCoordinates(getMaximumX());
            coordinatesGameCharacterMap.put(randomCoordinates, enemy);
        }
    }

    public Map<Coordinates, GameCharacter> getCoordinatesGameCharacterMap() {
        return coordinatesGameCharacterMap;
    }

    public Integer getMaximumX() {
        return maximumX;
    }

    public Integer getMaximumY() {
        return maximumY;
    }
}
