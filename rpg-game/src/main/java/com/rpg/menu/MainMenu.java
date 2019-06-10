package com.rpg.menu;

/**
 * Main menu for displaying before game starts.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 *
 */
public class MainMenu extends Menu {

    public MainMenu() {
        super();
        this.menuItems.put(1, "1 - Start a new game");
        this.menuItems.put(2, "2 - Load a saved game");
        this.menuItems.put(3, "3 - Save");
        this.menuItems.put(4, "4 - Exit");
        this.menuItems.remove(9);
    }


}
