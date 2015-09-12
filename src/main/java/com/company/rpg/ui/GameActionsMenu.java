package com.company.rpg.ui;

import com.company.rpg.map.locations.Location;
import com.company.rpg.map.locations.LocationType;

import java.util.ArrayList;
import java.util.List;

public class GameActionsMenu {

    public static void printMenu(Location location) {
        List<String> commands = buildMenu(location);
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i + 1 + "." + commands.get(i));
        }
    }

    private static List<String> buildMenu(Location location) {
        List<String> commands = new ArrayList<>();
        if (LocationType.MONSTER.equals(location.getLocationType())) {
            System.out.println("Monster descriptions goes here.");
            addFightCommands(commands);
        } else {
            addGameControlCommands(commands);
        }
        return commands;
    }

    private static void addGameControlCommands(List<String> commands) {
        commands.add("Print map");
        commands.add("Save game");
        commands.add("Load game");
        commands.add("Exit");
    }

    private static void addFightCommands(List<String> commands) {
        commands.add("Fight");
        commands.add("Escape");
    }
}
