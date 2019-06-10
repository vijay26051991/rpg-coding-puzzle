package com.rpg.menu;

import static com.rpg.utils.InputUtils.readIntAsInput;
import static com.rpg.utils.IntUtils.isNegative;
import static com.rpg.utils.PrintUtils.showMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * This abstract class should contain all of the common attributes of a menu (such as processing a menu option, or
 * returning to the previous menu).
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@.
 */
public abstract class Menu {

    /**
     * MenuItems with mappings.
     */
    Map<Integer, String> menuItems;

    /**
     * Player choice.
     */
    Integer menuChoice = 0;

    Menu() {
        menuItems = new HashMap<>();
        this.menuItems.put(9, "9 - Previous menu");
    }

    /**
     * Reading the input and set as choice.
     *
     * @since 1.0-SNAPSHOT.
     */
    public void menuAction() {
        this.menuItems.forEach((k, v) -> showMessage(v));
        int number = readIntAsInput();
        this.menuChoice = isNegative(number) ? -1 : number;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuItems=" + menuItems +
                '}';
    }

    public Map<Integer, String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Map<Integer, String> menuItems) {
        this.menuItems = menuItems;
    }

    public Integer getMenuChoice() {
        return menuChoice;
    }

    public void setMenuChoice(Integer menuChoice) {
        this.menuChoice = menuChoice;
    }
}
