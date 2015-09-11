package com.company.rpg.map;

public class Location {

    private String name;
    private String description;
    private LocationItem locationItem;
    private LocationType locationType;
    private Location topLocation;
    private Location downLocation;
    private Location leftLocation;
    private Location rightLocation;

    public Location(String name, String description, LocationItem locationItem, LocationType locationType,
                    Location topLocation, Location downLocation, Location leftLocation, Location rightLocation) {
        this.name = name;
        this.description = description;
        this.locationItem = locationItem;
        this.locationType = locationType;
        this.topLocation = topLocation;
        this.downLocation = downLocation;
        this.leftLocation = leftLocation;
        this.rightLocation = rightLocation;
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

    public Location getTopLocation() {
        return topLocation;
    }

    public void setTopLocation(Location topLocation) {
        this.topLocation = topLocation;
    }

    public Location getDownLocation() {
        return downLocation;
    }

    public void setDownLocation(Location downLocation) {
        this.downLocation = downLocation;
    }

    public Location getLeftLocation() {
        return leftLocation;
    }

    public void setLeftLocation(Location leftLocation) {
        this.leftLocation = leftLocation;
    }

    public Location getRightLocation() {
        return rightLocation;
    }

    public void setRightLocation(Location rightLocation) {
        this.rightLocation = rightLocation;
    }
}
