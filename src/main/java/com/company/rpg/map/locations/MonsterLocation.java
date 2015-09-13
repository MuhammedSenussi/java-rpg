package com.company.rpg.map.locations;

import com.company.rpg.map.MapMarker;
import com.company.rpg.model.NPC;
import com.company.rpg.ui.menu.AbstractMenu;
import com.company.rpg.ui.menu.MonsterLocationMenu;
import com.company.rpg.utils.RandomUtil;

import java.io.Serializable;

/**
 * Created by karmanov on 9/14/15.
 */
public class MonsterLocation extends Location implements Serializable {

    private static final String DESCRIPTION = "Monster location description";

    private MonsterLocationMenu locationMenu;

    public MonsterLocation(String name,
                           int x, int y, LocationItem monster) {
        super(name, DESCRIPTION, monster, LocationType.MONSTER, x, y, MapMarker.CLOSED);
        this.locationMenu = new MonsterLocationMenu();

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
