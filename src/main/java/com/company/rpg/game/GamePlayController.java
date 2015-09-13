package com.company.rpg.game;

import com.company.rpg.game.battle.BattleService;
import com.company.rpg.game.battle.BattleServiceImpl;
import com.company.rpg.map.Direction;
import com.company.rpg.map.WorldMap;
import com.company.rpg.map.locations.Location;
import com.company.rpg.map.locations.LocationItem;
import com.company.rpg.model.GameContext;
import com.company.rpg.model.NPC;
import com.company.rpg.model.Player;
import com.company.rpg.repository.GameContextRepository;
import com.company.rpg.ui.CommonCommands;
import com.company.rpg.ui.CommonCommandsExecutor;
import com.company.rpg.ui.menu.Menu;
import com.company.rpg.ui.menu.PlayerMenu;
import com.company.rpg.ui.menu.TopicMenu;
import com.company.rpg.utils.RandomUtil;

/**
 * @author Dmitriy Karmanov
 * @since 1.0
 */
public class GamePlayController {

    private static final int MAP_SIZE = 10;

    private Menu topicMenu;

    private Menu playerMenu;

    private GameContextRepository gameContextRepository;

    private BattleService battleService;

    private WorldMap worldMap;

    private boolean isGameOver;

    public GamePlayController() {
        this.gameContextRepository = new GameContextRepository();
        this.topicMenu = new TopicMenu();
        this.playerMenu = new PlayerMenu(gameContextRepository.getGameContext());
        this.battleService = new BattleServiceImpl();
    }

    public void play() {
        gameContextRepository.getGameContext().setTopic(selectTopic());
        gameContextRepository.getGameContext().setPlayer(createPlayer());
        initMap();
        while (!isGameOver) {
            showLocationInfo();
            executeCommand(gameContextRepository.getGameContext().getCurrentLocation());
        }
        System.out.println("Congratulations! You've explored all locations.");
        CommonCommandsExecutor.exit();
    }

    /**
     *
     */
    private void showLocationInfo() {
        Location currentLocation = gameContextRepository.getGameContext().getCurrentLocation();
        currentLocation.printLocationInfo();
    }

    /**
     * Display list of available topics for the game to the user.
     * Handle user input for selection
     *
     * @return selected game topic
     */
    private String selectTopic() {
        topicMenu.showMenu();
        int selectionIndex = topicMenu.getSelectionIndex();
        String topic = topicMenu.getCommandByIndex(selectionIndex);
        System.out.println("You've selected " + topic + " for the game");
        return topic;
    }

    /**
     * @return
     */
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

    /**
     *
     */
    private void printMap() {
        GameContext gameContext = gameContextRepository.getGameContext();
        worldMap.printMap(gameContext.getCurrentLocation(), gameContext.getTopic());
    }

    /**
     *
     */
    private void initMap() {
        if (worldMap == null) {
            worldMap = new WorldMap(MAP_SIZE);
            worldMap.init();
            Location currentLocation = worldMap.getLocation(0, 0);
            gameContextRepository.getGameContext().setCurrentLocation(currentLocation);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        }
    }

    /**
     * @param location
     */
    private void executeCommand(Location location) {
        int selectionIndex = location.getLocationMenu().getSelectionIndex();
        String command = location.getLocationMenu().getCommandByIndex(selectionIndex).toUpperCase();
        CommonCommands cmd = CommonCommands.valueOf(command);
        if (CommonCommands.NORTH.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.NORTH));
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (CommonCommands.SOUTH.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.SOUTH));
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (CommonCommands.WEST.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.WEST));
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (CommonCommands.EAST.equals(cmd)) {
            gameContextRepository.getGameContext().setCurrentLocation(worldMap.move(location, Direction.EAST));
            gameContextRepository.getGameContext().setWorldMap(worldMap);
            gameContextRepository.getGameContext().setWorldMap(worldMap);
        } else if (CommonCommands.SAVE.equals(cmd)) {
            CommonCommandsExecutor.save(gameContextRepository.getGameContext());
        } else if (CommonCommands.EXIT.equals(cmd)) {
            CommonCommandsExecutor.exit();
        } else if (CommonCommands.MAP.equals(cmd)) {
            printMap();
        } else if (CommonCommands.FIGHT.equals(cmd)) {
            NPC monster = (NPC) gameContextRepository.getGameContext().getCurrentLocation().getLocationItem();
            Player player = gameContextRepository.getGameContext().getPlayer();
            battleService.battle(player, monster);
        }
        isGameFinished();
    }

    /**
     * Check if game finished (all locations visited and all monsters defeated)
     * and switch of the flag
     */
    private void isGameFinished() {
        isGameOver = worldMap.isAllLocationsOpened();
    }
}
