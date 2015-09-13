package com.company.rpg.game;

import com.company.rpg.map.Direction;
import com.company.rpg.map.WorldMap;
import com.company.rpg.map.locations.EmptyLocation;
import com.company.rpg.map.locations.Location;
import com.company.rpg.model.Player;
import com.company.rpg.repository.GameContextRepository;
import com.company.rpg.ui.CommonCommands;
import com.company.rpg.ui.CommonCommandsExecutor;
import com.company.rpg.ui.menu.Menu;
import com.company.rpg.ui.menu.PlayerMenu;
import com.company.rpg.ui.menu.TopicMenu;
import com.company.rpg.utils.RandomUtil;

public class GamePlayController {

    private Menu topicMenu;

    private Menu playerMenu;

    private GameContextRepository gameContextRepository;

    private WorldMap worldMap;

    private boolean isGameOver;

    public GamePlayController() {
        this.gameContextRepository = new GameContextRepository();
        this.topicMenu = new TopicMenu();
        this.playerMenu = new PlayerMenu(gameContextRepository.getGameContext());
    }

    public void play() {
        gameContextRepository.getGameContext().setTopic(selectTopic());
        Player player = createPlayer();
        gameContextRepository.getGameContext().setPlayer(player);
        initMap();
        while (!isGameOver) {
            showLocationInfo();
            executeCommand(gameContextRepository.getGameContext().getCurrentLocation());
        }


    }

    private void showLocationInfo() {
        Location currentLocation = gameContextRepository.getGameContext().getCurrentLocation();
        currentLocation.printLocationInfo();
    }

    private String selectTopic() {
        topicMenu.showMenu();
        int selectionIndex = topicMenu.getSelectionIndex();
        String topic = topicMenu.getCommandByIndex(selectionIndex);
        System.out.println("You've selected " + topic + " for the game");
        return topic;
    }

    private Player createPlayer() {
        playerMenu.showMenu();
        int selectionIndex = playerMenu.getSelectionIndex();
        String playerName = playerMenu.getCommandByIndex(selectionIndex);
        System.out.println("You've selected " + playerName + " for the game");
        Player player = new Player(playerName, 100, 0, RandomUtil.nextIntInRange(10, 20),
                RandomUtil.nextIntInRange(10, 20), RandomUtil.nextIntInRange(5, 20));
        System.out.println(player);
        System.out.println();
        return player;

    }

    private void printMap() {
//        initMap();
        worldMap.printMap(gameContextRepository.getGameContext().getCurrentLocation());
    }

    private void initMap() {
        if (worldMap == null) {
            worldMap = new WorldMap(10);
            worldMap.init();
            Location currentLocation = new EmptyLocation("This is start point", 0, 0);
            gameContextRepository.getGameContext().setCurrentLocation(currentLocation);
        }
    }


    private void executeCommand(Location location) {
        int selectionIndex = location.getLocationMenu().getSelectionIndex();
        String command = location.getLocationMenu().getCommandByIndex(selectionIndex).toUpperCase();
        CommonCommands cmd = CommonCommands.valueOf(command);
        if (CommonCommands.NORTH.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.NORTH));
        } else if (CommonCommands.SOUTH.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.SOUTH));
        } else if (CommonCommands.WEST.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.WEST));
        } else if (CommonCommands.EAST.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.EAST));
        } else if (CommonCommands.SAVE.equals(cmd)) {
            CommonCommandsExecutor.save(gameContextRepository.getGameContext());
        } else if (CommonCommands.EXIT.equals(cmd)) {
            CommonCommandsExecutor.exit();
        } else if (CommonCommands.MAP.equals(cmd)) {
            printMap();
        }
    }

    private void isGameFinished() {
        //TODO add logic to check is game already finished
    }
}
