package com.company.rpg.game;

import com.company.rpg.map.MapItemType;
import com.company.rpg.model.Hero;
import com.company.rpg.model.NPC;
import com.company.rpg.battle.BattleService;
import com.company.rpg.ui.TextUIController;

import java.io.IOException;

/**
 * @author Dmitriy Kamranov
 * @since 1.0
 */
public class GameServiceImpl implements GameService {

    private BattleService battleService;

    private TextUIController uiController;

    public GameServiceImpl(BattleService battleService, TextUIController uiController) {
        this.battleService = battleService;
        this.uiController = uiController;
    }

    @Override
    public void startNewGame() throws IOException {
        System.out.println("What is your name?");
        System.out.print(" > ");
        String name = uiController.readInput();
        Hero hero = new Hero(name, 100, 0, 10, 10, 5);
        NPC goblin = new NPC("Goblin", 90, 0, 9, 9, 5, 100, MapItemType.MONSTER);
        battleService.battle(hero, goblin);
    }

    @Override
    public void save() {
        System.out.println("Saving current game....");
    }

    @Override
    public void load() {
        System.out.println("Loading game....");
    }

    @Override
    public void exit() {
        System.out.println("Thanks for the game. Come back soon");
        System.exit(0);
    }
}
