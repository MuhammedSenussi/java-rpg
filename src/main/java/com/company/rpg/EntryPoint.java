package com.company.rpg;

import com.company.rpg.game.GamePlayController;
import com.company.rpg.ui.CommonCommandsExecutor;
import com.company.rpg.ui.menu.MainMenu;
import com.company.rpg.ui.menu.Menu;

/**
 * Main entry point of the application
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {
        printBanner();
        Menu mainMenu = new MainMenu();
        mainMenu.showMenu();
        int selectionIndex = mainMenu.getSelectionIndex();
        if (1 == selectionIndex) {
            GamePlayController gamePlayController = new GamePlayController();
            gamePlayController.play();
        } else if (2 == selectionIndex) {
            CommonCommandsExecutor.load();
        } else if (3 == selectionIndex) {
            CommonCommandsExecutor.exit();
        } else if (4 == selectionIndex) {
            System.out.println("User's manual will be there");
        }

    }

    /**
     * Just print to the console game ASCII art
     */
    private static void printBanner() {
        //TODO add logic to print banner
        System.out.println("Banned will be here :))");
    }

}
