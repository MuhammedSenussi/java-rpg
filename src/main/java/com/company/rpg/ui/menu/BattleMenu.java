package com.company.rpg.ui.menu;

import java.io.Serializable;

/**
 * Created by karmanov on 9/14/15.
 */
public class BattleMenu extends AbstractMenu implements Serializable {


    @Override
    public void showMenu() {
        getCommands().clear();
        getCommands().add("Attack");
        getCommands().add("Charge Attack");
        getCommands().add("Escape from battle");
        System.out.println("What would you like to do?");
        System.out.println("");
        printCommands();
        System.out.print("> ");
    }
}
