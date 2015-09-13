package com.company.rpg.ui.menu;

import com.company.rpg.model.GameContext;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by karmanov on 9/12/15.
 */

public class PlayerMenu extends AbstractMenu {

    private GameContext gameContext;

    public PlayerMenu(GameContext gameContext) {
        this.gameContext = gameContext;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showMenu() {
        String topicKey = gameContext.getTopic().replaceAll(" ", "_").toLowerCase();
        try {
            Stream<String> availablePlayers = parseFile("assets/" + topicKey + ".txt");
            availablePlayers.forEach(s -> getCommands().add(s));
            System.out.println("Please select the character:");
            printCommands();
            System.out.print("> ");
        } catch (IOException e) {
            exitWithError("Could not load " + topicKey + " file. Please verify that file exist.");
        }

    }
}
