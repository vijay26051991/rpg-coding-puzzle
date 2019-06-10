package com.rpg.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Coordinates for the battle field.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@.
 */
public class Coordinates implements Serializable {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates up() {
        return new Coordinates(x - 1, y);
    }

    public Coordinates up(int i) {
        return new Coordinates(x - i, y);
    }

    public Coordinates down() {
        return new Coordinates(x + 1, y);
    }

    public Coordinates down(int i) {
        return new Coordinates(x + i, y);
    }

    public Coordinates left() {
        return new Coordinates(x, y - 1);
    }

    public Coordinates left(int i) {
        return new Coordinates(x, y - i);
    }


    public Coordinates right() {
        return new Coordinates(x, y + 1);
    }

    public Coordinates right(int i) {
        return new Coordinates(x, y + i);
    }

    public Coordinates diagonalUpRight() {
        return new Coordinates(x + 1, y + 1);
    }

    public Coordinates diagonalUpRight(int i) {
        return new Coordinates(x + i, y + i);
    }

    public Coordinates diagonalUpLeft() {
        return new Coordinates(x - 1, y + 1);
    }

    public Coordinates diagonalUpLeft(int i) {
        return new Coordinates(x - i, y + i);
    }

    public Coordinates diagonalDownLeft() {
        return new Coordinates(x - 1, y - 1);
    }

    public Coordinates diagonalDownLeft(int i) {
        return new Coordinates(x - i, y - i);
    }

    public Coordinates diagonalDownRight() {
        return new Coordinates(x + 1, y - 1);
    }

    public Coordinates diagonalDownRight(int i) {
        return new Coordinates(x + i, y - i);
    }

    @Override
    public String toString() {
        return x + "" + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates that = (Coordinates) o;

        return x == that.x && y == that.y;
    }

    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
