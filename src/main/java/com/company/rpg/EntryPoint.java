package com.company.rpg;

import com.company.rpg.game.GameState;
import com.company.rpg.ui.HeroSelectorController;
import com.company.rpg.ui.TopicSelectorController;

/**
 * Main entry point of the application
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {
        GameState gameState = new GameState();
        TopicSelectorController topicSelectorService = new TopicSelectorController(gameState);
        HeroSelectorController heroSelectorController = new HeroSelectorController(gameState);
        topicSelectorService.select();
        heroSelectorController.select();


//        CommandsReaderService commandsReaderService = new CommandsReaderServiceImpl();
//        BattleService battleService = new BattleServiceImpl(commandsReaderService);
//        GameServiceImpl gameService = new GameServiceImpl(battleService, commandsReaderService);
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
