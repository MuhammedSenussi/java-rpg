package com.company.rpg;

import com.company.rpg.game.GameService;
import com.company.rpg.game.GameServiceImpl;
import com.company.rpg.map.Direction;
import com.company.rpg.map.MapMarker;
import com.company.rpg.map.WorldMap;
import com.company.rpg.map.locations.EmptyLocation;
import com.company.rpg.map.locations.Location;
import com.company.rpg.ui.MainMenu;

/**
 * Main entry point of the application
 *
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {
//        GameService gameService = new GameServiceImpl();
//        MainMenu mainMenu = new MainMenu(gameService);
//        mainMenu.printMainMenu();

        Location startLocation = new EmptyLocation("This is start point", 0, 0);
        startLocation.setMapMarker(MapMarker.PLAYER);
        WorldMap worldMap = new WorldMap(10);
        worldMap.init();
        worldMap.printMap(startLocation);


        startLocation = worldMap.move(startLocation, Direction.EAST);
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        worldMap.printMap(startLocation);


//        startLocation = worldMap.move(startLocation, Direction.WEST);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
//        worldMap.printMap(startLocation);


//        startLocation = worldMap.move(startLocation, Direction.SOUTH);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
//        worldMap.printMap(startLocation);


//        startLocation = worldMap.move(startLocation, Direction.NORTH);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
//        worldMap.printMap(startLocation);
    }


}
