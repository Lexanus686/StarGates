package businesslogic.entities;

import businesslogic.StarGate;

public class Asteroid extends SpaceObject {

    public Asteroid(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, StarGate starGate, Galaxy location, String htmlInfo) {
        super(name, isAvailableToVisit, averageTemperature, gravitationPower, starGate, location, htmlInfo);
    }

    @Override
    public boolean isAvailableToVisit() {
        return super.isAvailableToVisit;
    }

    @Override
    public String getPlanetaryObjectName() {
        return super.name;
    }

    @Override
    public Float getAverageTemperature() {
        return super.averageTemperature;
    }

    @Override
    public Float getGravitationPower() {
        return super.gravitationPower;
    }

    @Override
    public StarGate getStargate() {
        return super.starGate;
    }

    @Override
    public Galaxy getLocation() {
        return super.location;
    }

    @Override
    public void setLocation(Galaxy location) {
        super.location = location;
    }

    @Override
    public void setHtmlInfo(String htmlInfo) {
        super.htmlInfo = htmlInfo;
    }

    @Override
    public String getHtmlInfo() {
        return super.htmlInfo;
    }
}
