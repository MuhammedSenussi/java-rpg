package com.company.rpg.ui;

import com.company.rpg.map.Location;
import com.company.rpg.map.LocationType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameActionsMenu {

    public static void printMenu(Location location) {
        List<String> commands = buildMenu(location);
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i + 1 + "." + commands.get(i));
        }
    }

    private static List<String> buildMenu(Location location) {
        List<String> commands = new ArrayList<>();
        if (LocationType.MONSTER.equals(location.getMapItem().getType())) {
            System.out.println("Monster descriptions goes here.");
            addFightCommands(commands);
        } else {
            addGameControlCommands(commands);
            addMoveCommands(commands, location);
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

    private static void addMoveCommands(List<String> commands, Location location) {
        Location topLocation = location.getTopLocation();
        Location downLocation = location.getDownLocation();
        Location rightLocation = location.getRightLocation();
        Location leftLocation = location.getLeftLocation();
        if (topLocation != null) {
            commands.add("Go up");
        }
        if (downLocation != null) {
            commands.add("Go down");
        }
        if (leftLocation != null) {
            commands.add("Go left");
        }
        if (rightLocation != null) {
            commands.add("Go right");
        }
    }
}
