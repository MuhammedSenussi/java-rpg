package com.company.rpg;

import com.company.rpg.battle.BattleService;
import com.company.rpg.battle.BattleServiceImpl;
import com.company.rpg.game.GameService;
import com.company.rpg.game.GameServiceImpl;
import com.company.rpg.game.GameState;
import com.company.rpg.ui.HeroSelectorController;
import com.company.rpg.ui.MainMenu;
import com.company.rpg.ui.TextUIController;
import com.company.rpg.ui.TopicSelectorController;

import java.io.IOException;

/**
 * Main entry point of the application
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        MainMenu mainMenu = new MainMenu(gameService);
        try {
            mainMenu.printMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        MainMenu mainMenu = new MainMenu(gameService);
//        try {
//            mainMenu.printMainMenu();
//        } catch (IOException e) {
//            System.err.println("An error occurred");
//        }

//        WorldMap worldMap = new WorldMap();
//        worldMap.init();
//        worldMap.printMap();
//        worldMap.move(5, 5);
//        worldMap.printMap();
    }


}
