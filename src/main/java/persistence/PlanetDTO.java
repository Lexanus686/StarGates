package persistence;

import businesslogic.Galaxy;
import businesslogic.StarGate;

public class PlanetDTO {
    private int id;
    String name; ////название объекта
    boolean isAvailableToVisit; //возможность посещения человеческой расой
    float averageTemperature; //средняя температура
    float gravitationPower; //сила гравитации (в g)
    StarGate starGate;
    Galaxy location;
    String htmlInfo;

    public PlanetDTO(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, StarGate starGate, Galaxy location, String htmlInfo) {
        this.name = name;
        this.isAvailableToVisit = isAvailableToVisit;
        this.averageTemperature = averageTemperature;
        this.gravitationPower = gravitationPower;
        this.starGate = starGate;
        this.location = location;
        this.htmlInfo = htmlInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailableToVisit() {
        return isAvailableToVisit;
    }

    public void setAvailableToVisit(boolean availableToVisit) {
        isAvailableToVisit = availableToVisit;
    }

    public float getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(float averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public float getGravitationPower() {
        return gravitationPower;
    }

    public void setGravitationPower(float gravitationPower) {
        this.gravitationPower = gravitationPower;
    }

    public StarGate getStarGate() {
        return starGate;
    }

    public void setStarGate(StarGate starGate) {
        this.starGate = starGate;
    }

    public Galaxy getLocation() {
        return location;
    }

    public void setLocation(Galaxy location) {
        this.location = location;
    }

    public String getHtmlInfo() {
        return htmlInfo;
    }

    public void setHtmlInfo(String htmlInfo) {
        this.htmlInfo = htmlInfo;
    }
}
