package com.company.rpg.model;

import com.company.rpg.map.MapItem;
import com.company.rpg.map.MapItemType;

public class NPC extends Hero implements MapItem {

    private final int expCost;

    private MapItemType type;

    public NPC(String name, int health, int experience, int damage, int defence, int agility, int expCost,
               MapItemType type) {
        super(name, health, experience, damage, agility, defence);
        this.expCost = expCost;
        this.type = type;
    }

    public int getExpCost() {
        return expCost;
    }

    @Override
    public MapItemType getType() {
        return type;
    }
}
