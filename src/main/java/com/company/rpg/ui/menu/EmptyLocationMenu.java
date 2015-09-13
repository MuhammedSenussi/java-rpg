package com.company.rpg.ui.menu;

import java.io.Serializable;

public class EmptyLocationMenu extends AbstractMenu implements Serializable {

    @Override
    public void showMenu() {
        getCommands().clear();
        System.out.println("Please select an action: ");
        getCommands().add("North");
        getCommands().add("South");
        getCommands().add("West");
        getCommands().add("East");
        getCommands().add("Map");
        getCommands().add("Save");
        getCommands().add("Exit");
        printCommands();
        System.out.println(">");
    }
}
