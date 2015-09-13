package com.company.rpg.model;

import com.company.rpg.map.WorldMap;
import com.company.rpg.map.locations.Location;
import com.company.rpg.model.Player;

import java.io.Serializable;

/**
 * Contains all main parameters of the current game, such as
 * selected topic, player, player's current location and state of the world
 * User for saving and restoring the game
 *
 * @author Dmitriy Kamranov
 * @since 1.0
 */
public class GameContext implements Serializable {

    private String topic;

    private Player player;

    private Location currentLocation;

    private WorldMap worldMap;

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

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
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
