package com.company.rpg;

import com.company.rpg.ui.TopicSelectorController;

/**
 * Main entry point of the application
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {
        TopicSelectorController topicSelectorService = new TopicSelectorController();
        topicSelectorService.execute();

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
