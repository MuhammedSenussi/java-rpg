package com.company.rpg;

import java.io.IOException;

public class MainMenu {

    private GameService gameService;

    public MainMenu(GameService gameService) {
        this.gameService = gameService;
    }

    public void printMainMenu() throws IOException {
        System.out.println("Commandline JavaRPG - Main menu");
        System.out.println("Main Menu");
        System.out.println("1. Start new game");
//        System.out.println("2. Load game");
//        System.out.println("2. Exit");
//        System.out.println("3. Credits");
//        System.out.println("4. Tutorial/Instructions/Etc");
        System.out.print(" > ");

        int selection = MenuUtils.getSelection(4);
        if (1 == selection) {
            gameService.startNewGame();
        } else if (2 == selection) {
            System.out.println(2);
        } else if (3 == selection) {
            System.out.println(3);
        } else if (4 == selection) {
            System.out.println(4);
        }

    }
}