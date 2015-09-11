package com.company.rpg.game;

import com.company.rpg.battle.BattleServiceImpl;
import com.company.rpg.battle.BattleService;
import com.company.rpg.ui.HeroSelectorController;
import com.company.rpg.ui.TextUIController;
import com.company.rpg.ui.TopicSelectorController;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @author Dmitriy Kamranov
 * @since 1.0
 */
public class GameServiceImpl implements GameService {

    private TextUIController uiController;

    private BattleService battleService;

    private GameState gameState;

    public GameServiceImpl() {
        this.uiController = new TextUIController();
        this.battleService = new BattleServiceImpl(uiController);
    }

    @Override
    public void startNewGame() throws IOException {
        gameState = new GameState();
        TopicSelectorController topicSelectorService = new TopicSelectorController(uiController, gameState);
        HeroSelectorController heroSelectorController = new HeroSelectorController(uiController, gameState);
        topicSelectorService.select();
        heroSelectorController.select();
        System.out.println("Hero created. ");
        System.out.println(gameState.getHero().toString());
        System.out.println("So, let's start the adventure!!!");

        System.out.print("> ");
        uiController.readInput();


//        NPC goblin = new NPC("Goblin", 90, 0, 9, 9, 5, 100, MapItemType.MONSTER);
//        battleService.battle(hero, goblin);
    }

    @Override
    public void save(GameState gameState) {
        System.out.println("Saving current game....");
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("saved/" + localDateTime.toString() + ".ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameState);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public GameState load() {
        System.out.println("Loading game....");
        try {
            ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("game.ser")));
            return (GameState) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred during loading the game. Reason: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void exit() {
        System.out.println("Thanks for the playing! Come back soon.");
        System.exit(0);
    }


    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public TextUIController getUiController() {
        return uiController;
    }
}
