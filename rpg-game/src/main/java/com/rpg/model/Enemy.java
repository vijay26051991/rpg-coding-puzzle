package com.rpg.model;

/**
 * Extending game character characteristics for Enemy.
 * Model for enemy.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@.
 */
public class Enemy extends GameCharacter{

    //TODO: Define monster attributes (name, size, hitPoints) and rewards for defeat, if any

   private final boolean isEnemyAlive;

    public Enemy(boolean isEnemyAlive) {
        super();
        this.isEnemyAlive = isEnemyAlive;
    }

    public boolean isEnemyAlive() {
        return isEnemyAlive;
    }
}
