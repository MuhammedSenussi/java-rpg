package com.company.rpg.map.locations;

import com.company.rpg.map.MapMarker;
import com.company.rpg.ui.menu.AbstractMenu;
import com.company.rpg.ui.menu.EmptyLocationMenu;

import java.io.Serializable;

public class EmptyLocation extends Location implements Serializable {

    private EmptyLocationMenu locationMenu;

    private static final String DESCRIPTION = "Empty location description \n";

    public EmptyLocation(String name, int x, int y) {
        super(name, DESCRIPTION, null, LocationType.EMPTY, x, y, MapMarker.CLOSED);
        this.locationMenu = new EmptyLocationMenu();
    }

    @Override
    public void printLocationInfo() {
        System.out.println("You are at " + getName() + "\n");
        System.out.println(DESCRIPTION);
        locationMenu.showMenu();
    }

    @Override
    public AbstractMenu getLocationMenu() {
        return locationMenu;
    }
}
