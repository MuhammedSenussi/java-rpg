package com.company.rpg.map;

import com.company.rpg.map.locations.EmptyLocation;
import com.company.rpg.map.locations.Location;

import java.util.Arrays;

public class WorldMap {

    private static final String MAP_WHITESPACE = "     ";

    private Location currentLocation;

    private String[][] map;

    private int mapSize;

    public WorldMap(int mapSize) {
        this.mapSize = mapSize;
        this.map = new String[mapSize][mapSize];
        this.currentLocation = new EmptyLocation("This is start point", 0, 0);
    }

    public void printMap(Location location) {
        System.out.println("Map of MapRuntimeException's world");
        printBorder();
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (location.getX() == i && location.getY() == j) {
                    System.out.print("P" + MAP_WHITESPACE);
//                    System.out.println(location.getMapMarker().getMarker() + MAP_WHITESPACE);
                } else {
                    System.out.print(map[i][j] + MAP_WHITESPACE);
                }
            }
            System.out.println();
        }
        printBorder();
        System.out.println();
        printLegend();
    }

    private void printBorder() {
        for (int i = 0; i < map.length + ((map.length - 1) * 5); i++) {
            System.out.print("-");
        }
    }

    public void init() {
        for (String[] row : map)
            Arrays.fill(row, "*");
    }

    public Location move(Location location, Direction direction) {
        int x = location.getX();
        int y = location.getY();
        if (Direction.EAST.equals(direction)) {
            if (location.getY() == mapSize) {
                printError();
            } else {
                y++;
                map[x][y] = MapMarker.PLAYER.getMarker();
                map[location.getX()][location.getY()] = "0";
            }
        } else if (Direction.WEST.equals(direction)) {
            if (location.getY() == 0) {
                printError();
            } else {
                y--;
                map[x][y] = MapMarker.PLAYER.getMarker();
                map[location.getX()][location.getY()] = "0";
            }

        } else if (Direction.NORTH.equals(direction)) {
            if (location.getX() == 0) {
                printError();
            } else {
                x--;
                map[x][y] = MapMarker.PLAYER.getMarker();
                map[location.getX()][location.getY()] = "0";
            }
        } else if (Direction.SOUTH.equals(direction)) {
            if (location.getX() == mapSize) {
                printError();
            } else {
                x++;
                map[x][y] = MapMarker.PLAYER.getMarker();
                map[location.getX()][location.getY()] = "0";
            }
        }
        location.setX(x);
        location.setY(y);
        return location;
    }

    private void printLegend() {
        System.out.println("Legend:");
        System.out.println("    0 = Explored empty locations");
        System.out.println("    * = Unexplored empty locations");
        System.out.println("    M = Location with monster");
        System.out.println("    P = Current player's location");


    }

    private void printError() {
        System.err.println("> WARNING: Dragons live further, please find another way");
    }
}
