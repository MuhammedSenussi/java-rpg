package com.company.rpg.game;

import com.company.rpg.map.Location;
import com.company.rpg.model.Hero;

import java.io.Serializable;

public class GameState implements Serializable {

    private String topic;

    private Hero hero;

    private Location currentLocation;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "topic='" + topic + '\'' +
                ", hero=" + hero +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
