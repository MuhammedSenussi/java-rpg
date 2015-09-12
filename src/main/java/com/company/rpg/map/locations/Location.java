package com.company.rpg.map.locations;

import com.company.rpg.map.MapMarker;

public abstract class Location {

    private String name;
    private String description;
    private LocationItem locationItem;
    private LocationType locationType;
    private int x;
    private int y;
    private MapMarker mapMarker;

    public Location(String name, String description, LocationItem locationItem, LocationType locationType,
                    int x, int y, MapMarker mapMarker) {
        this.name = name;
        this.description = description;
        this.locationItem = locationItem;
        this.locationType = locationType;
        this.x = x;
        this.y = y;
        this.mapMarker = mapMarker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocationItem getLocationItem() {
        return locationItem;
    }

    public void setLocationItem(LocationItem locationItem) {
        this.locationItem = locationItem;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MapMarker getMapMarker() {
        return mapMarker;
    }

    public void setMapMarker(MapMarker mapMarker) {
        this.mapMarker = mapMarker;
    }
}
