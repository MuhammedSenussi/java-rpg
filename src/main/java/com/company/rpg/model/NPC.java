package com.company.rpg.model;

public class NPC extends Hero {

    private int expCost;

    public NPC(String name, int health, int experience, int damage, int defence, int agility, int expCost) {
        super(name, health, experience, damage, agility, defence);
        this.expCost = expCost;
    }

    public int getExpCost() {
        return expCost;
    }

    public void setExpCost(int expCost) {
        this.expCost = expCost;
    }
}
