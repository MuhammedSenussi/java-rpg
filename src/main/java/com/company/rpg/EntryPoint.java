package com.company.rpg;

import com.company.rpg.game.GamePlayController;
import com.company.rpg.game.model.GameContext;
import com.company.rpg.repository.GameContextRepository;
import com.company.rpg.ui.CommonCommandsExecutor;
import com.company.rpg.ui.menu.MainMenu;
import com.company.rpg.ui.menu.Menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        GameContextRepository gameContextRepository = new GameContextRepository();
        GamePlayController gamePlayController = new GamePlayController(gameContextRepository);
        mainMenu.showMenu();
        int selectionIndex = mainMenu.getSelectionIndex();
        if (1 == selectionIndex) {
            gamePlayController.startGame();
        } else if (2 == selectionIndex) {
            GameContext gameContext = CommonCommandsExecutor.load();
            gameContextRepository.setGameContext(gameContext);
            gamePlayController.continueGame();
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
        try {
            String banner = new String(Files.readAllBytes(Paths.get("assets/banner.txt")));
            System.out.println(banner + "\n");
        } catch (IOException e) {
            //It's not critical, so do nothing
        }
    }

}
