package com.company.rpg.map;

import com.company.rpg.map.locations.EmptyLocation;
import com.company.rpg.map.locations.Location;

public class WorldMap {

    private static final String MAP_WHITESPACE = "     ";

    private Location[][] map;

    private int mapSize;

    public WorldMap(int mapSize) {
        this.mapSize = mapSize;
        this.map = new Location[mapSize][mapSize];
    }

    public void printMap(Location currentLocation) {
        System.out.println("            Map of MapRuntimeException's world");
        printBorder();
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (currentLocation.getX() == i && currentLocation.getY() == j) {
                    System.out.print(MapMarker.PLAYER.getMarker() + MAP_WHITESPACE);
                } else {
                    System.out.print(map[i][j].getMapMarker().getMarker() + MAP_WHITESPACE);
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
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = new EmptyLocation("This is start point", i, j);
            }
        }
    }

    public Location move(Location location, Direction direction) {
        int x = location.getX();
        int y = location.getY();
        if (Direction.EAST.equals(direction)) {
            if (location.getY() == mapSize) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                y++;
            }
        } else if (Direction.WEST.equals(direction)) {
            if (location.getY() == 0) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                y--;
            }

        } else if (Direction.NORTH.equals(direction)) {
            if (location.getX() == 0) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                x--;
            }
        } else if (Direction.SOUTH.equals(direction)) {
            if (location.getX() == mapSize) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                x++;
            }
        }
        location.setX(x);
        location.setY(y);
        return location;
    }

    private void printLegend() {
        System.out.println("Legend:");
        System.out.println("    0 = Explored empty location");
        System.out.println("    * = Unexplored location");
        System.out.println("    M = Location with monster");
        System.out.println("    P = Current player's location");
        System.out.println();


    }

    private void printError() {
        System.err.println("> WARNING: Dragons live further, please find another way");
    }
}
