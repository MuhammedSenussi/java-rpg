package com.company.rpg;

import com.company.rpg.services.BattleService;
import com.company.rpg.services.CommandsReaderService;
import com.company.rpg.services.impl.BattleServiceImpl;
import com.company.rpg.services.impl.CommandsReaderServiceImpl;

import java.io.IOException;

/**
 * Main entry point of the application
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {
        CommandsReaderService commandsReaderService = new CommandsReaderServiceImpl();
        BattleService battleService = new BattleServiceImpl(commandsReaderService);
        GameServiceImpl gameService = new GameServiceImpl(battleService, commandsReaderService);
        MainMenu mainMenu = new MainMenu(gameService);
        try {
            mainMenu.printMainMenu();
        } catch (IOException e) {
            System.err.println("An error occurred");
        }

//        WorldMap worldMap = new WorldMap();
//        worldMap.init();
//        worldMap.printMap();
//        worldMap.move(5, 5);
//        worldMap.printMap();
    }


}
