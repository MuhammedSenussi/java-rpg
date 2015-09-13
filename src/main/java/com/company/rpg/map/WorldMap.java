package com.company.rpg.map;

import com.company.rpg.map.locations.EmptyLocation;
import com.company.rpg.map.locations.Location;
import com.company.rpg.map.locations.MonsterLocation;
import com.company.rpg.model.NPC;

import java.io.Serializable;

public class WorldMap implements Serializable {

    private static final String MAP_WHITESPACE = "     ";

    private Location[][] map;

    private int mapSize;

    public WorldMap(int mapSize) {
        this.mapSize = mapSize;
        this.map = new Location[mapSize][mapSize];
    }

    public void printMap(Location currentLocation, String topic) {
        System.out.println("Map of " + topic + "'s world");
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
                if (i == 0 && j == 0) {
                    NPC monster = new NPC("Super monster", 90, 100, 10, 10, 10, 50);
                    map[i][j] = new MonsterLocation("This is monster location", i, j, monster);
                } else {
                    map[i][j] = new EmptyLocation("This is start point", i, j);
                }

            }
        }
    }

    public boolean isAllLocationsOpened() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                Location location = map[i][j];
                if (!location.isOpened()) {
                    return false;
                }

            }
        }
        return true;
    }

    public Location getLocation(int x, int y) {
        return map[x][y];
    }

    public Location move(Location location, Direction direction) {
        int x = location.getX();
        int y = location.getY();
        if (Direction.EAST.equals(direction)) {
            if (y == mapSize - 1) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                y++;
            }
        } else if (Direction.WEST.equals(direction)) {
            if (y == 0) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                y--;
            }

        } else if (Direction.NORTH.equals(direction)) {
            if (x == 0) {
                printError();
            } else {
                map[x][y].setIsOpened(true);
                map[x][y].setMapMarker(MapMarker.EMPTY);
                x--;
            }
        } else if (Direction.SOUTH.equals(direction)) {
            if (x == mapSize - 1) {
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
