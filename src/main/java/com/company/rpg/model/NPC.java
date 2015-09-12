package com.company.rpg.model;

import com.company.rpg.map.locations.LocationItem;

public class NPC extends Hero implements LocationItem {

    private final int expCost;

    public NPC(String name, int health, int experience, int damage, int defence, int agility, int expCost) {
        super(name, health, experience, damage, agility, defence);
        this.expCost = expCost;
    }

    public int getExpCost() {
        return expCost;
    }
}
