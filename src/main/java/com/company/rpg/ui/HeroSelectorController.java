package com.company.rpg.ui;

import com.company.rpg.game.GameState;
import com.company.rpg.map.EmptyLocation;
import com.company.rpg.map.Location;
import com.company.rpg.model.Hero;
import com.company.rpg.utils.RandomUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HeroSelectorController {

    private TextUIController uiController;

    private GameState gameState;


    public HeroSelectorController(TextUIController uiController, GameState gameState) {
        this.uiController = uiController;
        this.gameState = gameState;
    }

    public void select() {
        List<String> heroes = new ArrayList<>();
        String topicKey = gameState.getTopic().replaceAll(" ", "_").toLowerCase();
        try {
            Stream<String> heroesStream = uiController.loadConfigFile("assets/" + topicKey + ".txt");
            heroesStream.forEach(h -> heroes.add(h));
            uiController.printMessage("Please select the hero");
            uiController.printIndexedList(heroes);
            System.out.print("> ");
            int selection = uiController.getSelection(heroes.size());
            String heroName = heroes.get(selection - 1);
            uiController.printMessage("You selected: " + heroName);
            Hero hero = new Hero(heroName, 100, 0, RandomUtil.nextIntInRange(10, 20),
                    RandomUtil.nextIntInRange(10, 20), RandomUtil.nextIntInRange(5, 20));
            gameState.setHero(hero);
        } catch (IOException e) {
            uiController.exitWithError("Could not load " + topicKey + " file. Please verify that file exist.");
        }
    }
}
