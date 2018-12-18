package businesslogic.entities;

import businesslogic.StarGate;

public abstract class SpaceObject {

    String name;
    boolean isAvailableToVisit;
    float averageTemperature;
    float gravitationPower;
    StarGate starGate;
    Galaxy location;
    String htmlInfo;

    public SpaceObject(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, StarGate starGate, Galaxy location, String htmlInfo) {
        this.name = name;
        this.isAvailableToVisit = isAvailableToVisit;
        this.averageTemperature = averageTemperature;
        this.gravitationPower = gravitationPower;
        this.starGate = starGate;
        this.location = location;
        this.htmlInfo = htmlInfo;
    }

    public abstract void setLocation(Galaxy galaxyType);

    public abstract boolean isAvailableToVisit();

    public abstract String getPlanetaryObjectName();

    public abstract Float getAverageTemperature();

    public abstract Float getGravitationPower();

    public abstract StarGate getStargate();

    public abstract Galaxy getLocation();

    public abstract void setHtmlInfo(String htmlInfo);

    public abstract String getHtmlInfo();
}
