package com.company.rpg.model;

public class Hero {

    private String name;
    private int health;
    private int experience;
    private int damage;
    private int defence;
    private int agility;

    public Hero(String name, int health, int experience, int damage, int defence, int agility) {
        this.name = name;
        this.health = health;
        this.experience = experience;
        this.damage = damage;
        this.defence = defence;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void addExp(int exp) {
        this.experience += exp;
    }

    public void increaseDamage(int factor) {
        this.damage += factor;
    }

    public void increaseDamageOnOnePoint() {
        increaseDamage(1);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", experience=" + experience +
                ", damage=" + damage +
                ", defence=" + defence +
                ", agility=" + agility +
                '}';
    }
}
