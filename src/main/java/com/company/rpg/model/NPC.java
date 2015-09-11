package com.company.rpg.model;

import com.company.rpg.map.LocationItem;
import com.company.rpg.map.LocationType;

public class NPC extends Hero implements LocationItem {

    private final int expCost;

    private LocationType type;

    public NPC(String name, int health, int experience, int damage, int defence, int agility, int expCost,
               LocationType type) {
        super(name, health, experience, damage, agility, defence);
        this.expCost = expCost;
        this.type = type;
    }

    public int getExpCost() {
        return expCost;
    }

    @Override
    public LocationType getType() {
        return type;
    }
}
