package persistence;

import businesslogic.StarGate;
import businesslogic.entities.Galaxy;

public class PlanetDTO {
    private int id;
    private String name; ////название объекта
    private boolean isAvailableToVisit; //возможность посещения человеческой расой
    private float averageTemperature; //средняя температура
    private float gravitationPower; //сила гравитации (в g)
    private StarGate starGate;
    private Galaxy location;
    private String htmlInfo;

    PlanetDTO(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, StarGate starGate, Galaxy location, String htmlInfo) {
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

    boolean isAvailableToVisit() {
        return isAvailableToVisit;
    }

    public void setAvailableToVisit(boolean availableToVisit) {
        isAvailableToVisit = availableToVisit;
    }

    float getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(float averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    float getGravitationPower() {
        return gravitationPower;
    }

    public void setGravitationPower(float gravitationPower) {
        this.gravitationPower = gravitationPower;
    }

    StarGate getStarGate() {
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

    String getHtmlInfo() {
        return htmlInfo;
    }

    public void setHtmlInfo(String htmlInfo) {
        this.htmlInfo = htmlInfo;
    }
}
