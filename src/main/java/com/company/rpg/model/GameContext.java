package com.company.rpg.model;

import com.company.rpg.map.locations.Location;
import com.company.rpg.model.Player;

import java.io.Serializable;

public class GameContext implements Serializable {

    private String topic;

    private Player player;

    private Location currentLocation;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
                ", player=" + player +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
