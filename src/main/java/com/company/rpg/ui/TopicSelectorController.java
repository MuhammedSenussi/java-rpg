package com.company.rpg.ui;

import com.company.rpg.game.GameState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TopicSelectorController {

    private TextUIController uiController;

    private GameState gameState;

    public TopicSelectorController(TextUIController uiController, GameState gameState) {
        this.uiController = uiController;
        this.gameState = gameState;
    }

    public void select() {
        List<String> topics = new ArrayList<>();
        try {
            Stream<String> lines = uiController.loadConfigFile("assets/topics_list.txt");
            lines.forEach(s -> topics.add(s));
            uiController.printInto();
            uiController.printMessage("Please select game topic");
            uiController.printIndexedList(topics);
            System.out.print("> ");
            int selection = uiController.getSelection(topics.size());
            String topic = topics.get(selection - 1);
            uiController.printMessage("You selected: " + topic);
            gameState.setTopic(topic);
        } catch (IOException ex) {
            uiController.exitWithError("Could not load topics.txt file. Please verify that 'assets/topics.txt file exist");
        }
    }

}
