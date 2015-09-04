package com.company.rpg.menu;

public class MainMenu {

    public void printMainMenu() {
        System.out.println("Commandline JavaRPG - Main menu");
        System.out.println("Main Menu");
        System.out.println("1. Start New Game");
        System.out.println("2. Exit");
        System.out.println("3. Credits");
        System.out.println("4. Tutorial/Instructions/Etc");
        System.out.print(" > ");

        int selection = MenuUtils.getSelection(4);
        if (1 == selection) {
            System.out.println(1);
        } else if (2 == selection) {
            System.out.println(2);
        } else if (3 == selection) {
            System.out.println(3);
        } else if (4 == selection) {
            System.out.println(4);
        }

    }
}
