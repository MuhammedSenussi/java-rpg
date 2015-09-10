package com.company.rpg.ui;

import com.company.rpg.game.GameState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TopicSelectorController extends TextUIController {

    public TopicSelectorController(GameState gameState) {
        super(gameState);
    }

    public String select() {
        String topic = "";
        List<String> topics = new ArrayList<>();
        try {
            Stream<String> lines = loadConfigFile("assets/topics_list.txt");
            lines.forEach(s -> topics.add(s));
            printInto();
            printMessage("Please select game topic");
            printIndexedList(topics);
            System.out.print("> ");
            int selection = getSelection(topics.size());
            topic = topics.get(selection - 1);
        } catch (IOException ex) {
            exitWithError("Could not load topics.txt file. Please verify that 'assets/topics.txt file exist");
        }
        if (topic == null || topic.isEmpty()) {
            exitWithError("Could not load topics.txt file. Please verify that 'assets/topics.txt file exist");
        }
        System.out.println("You selected: " + topic);
        getGameState().setTopic(topic);
        return topic;
    }

}
