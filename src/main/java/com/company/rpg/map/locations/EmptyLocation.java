package com.company.rpg.map.locations;

import com.company.rpg.map.MapMarker;

public class EmptyLocation extends Location {

    private static final String DESCRIPTION = "Empty location description";

    public EmptyLocation(String name, int x, int y) {
        super(name, DESCRIPTION, null, LocationType.EMPTY, x, y, MapMarker.EMPTY);
    }
}
