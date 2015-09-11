package com.company.rpg.ui;

import com.company.rpg.game.GameService;

import java.io.IOException;

public class MainMenu {

    GameService gameService;

    public MainMenu(GameService gameService) {
        this.gameService = gameService;
    }

    public void printMainMenu() throws IOException {
        System.out.println("Main Menu");
        System.out.println("1. Start new game");
        System.out.println("2. Load game");
        System.out.println("2. Exit");
        System.out.println("3. Credits");
        System.out.println("4. Tutorial/Instructions/Etc");
        System.out.print("> ");

        int selection = gameService.getUiController().getSelection(4);
        if (1 == selection) {
            gameService.startNewGame();
        } else if (2 == selection) {
            gameService.load();
            System.out.println(2);
        } else if (3 == selection) {
            gameService.exit();
        } else if (4 == selection) {
            System.out.println("Show manual");
        }

    }
}
