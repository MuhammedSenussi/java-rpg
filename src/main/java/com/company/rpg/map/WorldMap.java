package com.company.rpg.map;

import java.util.Arrays;

public class WorldMap {

    private String[][] map = new String[10][10];

    public void printMap() {
        for (int i = 0; i < map.length + (map.length - 1); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < map.length + (map.length - 1); i++) {
            System.out.print("-");
        }
        System.out.println();
    }


    public void init() {
        for (String[] row : map)
            Arrays.fill(row, "*");
    }

    public void move(int x, int y) {
        map[x][y] = "P";
    }
}
