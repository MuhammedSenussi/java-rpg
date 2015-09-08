package com.company.rpg;

import com.company.rpg.model.Hero;
import com.company.rpg.model.Monster;
import com.company.rpg.services.BattleService;
import com.company.rpg.services.CommandsReaderService;

import java.io.IOException;

/**
 * @author Dmitriy Kamranov
 * @since 1.0
 */
public class GameServiceImpl implements GameService {

    private BattleService battleService;

    private CommandsReaderService commandsReaderService;

    public GameServiceImpl(BattleService battleService, CommandsReaderService commandsReaderService) {
        this.battleService = battleService;
        this.commandsReaderService = commandsReaderService;
    }

    @Override
    public void startNewGame() throws IOException {
        System.out.println("What is your name?");
        System.out.print(" > ");
        String name = commandsReaderService.readInput();
        Hero hero = new Hero(name, 100, 0, 10, 10, 5);
        Monster goblin = new Monster("Goblin", 90, 0, 9, 9, 5, 100);
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
}
