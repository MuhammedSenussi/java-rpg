package com.company.rpg.map;

/**
 * Created by karmanov on 9/12/15.
 */
public enum MapMarker {

    PLAYER("P"), EMPTY("*"), MONSTER("M"), OPENED("0");

    private final String marker;

    MapMarker(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }
}
