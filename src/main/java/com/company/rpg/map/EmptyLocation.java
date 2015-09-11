package com.company.rpg.map;

public class EmptyLocation extends Location {

    private static final String DESCRIPTION = "Empty location description";

    public EmptyLocation(String name, Location topLocation, Location downLocation, Location leftLocation,
                         Location rightLocation) {
        super(name, DESCRIPTION, null, LocationType.EMPTY, topLocation, downLocation, leftLocation, rightLocation);
    }
}
