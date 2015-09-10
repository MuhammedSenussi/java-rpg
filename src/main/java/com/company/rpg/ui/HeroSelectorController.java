package com.company.rpg.ui;

import com.company.rpg.game.GameState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HeroSelectorController extends TextUIController {

    public HeroSelectorController(GameState gameState) {
        super(gameState);
    }

    public String select() {
        String heroName = "";
        List<String> heroes = new ArrayList<>();
        String topicKey = getGameState().getTopic().replaceAll(" ", "_").toLowerCase();
        try {
            Stream<String> heroesStream = loadConfigFile("assets/" + topicKey + ".txt");
            heroesStream.forEach(h -> heroes.add(h));
            printMessage("Please select the hero");
            printIndexedList(heroes);
            System.out.print("> ");
            int selection = getSelection(heroes.size());
            heroName = heroes.get(selection - 1);
        } catch (IOException e) {
            exitWithError("Could not load " + topicKey + " file. Please verify that file exist.");
        }
        System.out.println("You selectde: " + heroName);
        return heroName;
    }


}
