package businesslogic.entities;

import businesslogic.StarGate;

public class Planet extends SpaceObject {

    public Planet(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, String stargateName, Galaxy location, String htmlInfo) {
        super(name, isAvailableToVisit, averageTemperature, gravitationPower, new StarGate(stargateName), location, htmlInfo);
    }

    public Planet(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, String stargateName, boolean isActivated, Galaxy location, String htmlInfo) {
        super(name, isAvailableToVisit, averageTemperature, gravitationPower, new StarGate(stargateName, isActivated), location, htmlInfo);
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
    public boolean isAvailableToVisit() {
        return super.isAvailableToVisit;
    }

    @Override
    public void setLocation(Galaxy location) {
        super.location = location;
    }

    @Override
    public Galaxy getLocation() {
        return super.location;
    }

    @Override
    public String getPlanetaryObjectName() {
        return super.name;
    }

    @Override
    public StarGate getStargate() {
        return super.starGate;
    }

    @Override
    public void setHtmlInfo(String htmlInfo) {
        super.htmlInfo = htmlInfo;
    }

    @Override
    public String getHtmlInfo() {
        return super.htmlInfo;
    }

    public static Planet initPlanet(String[] array) {

        float temp = array[2].equals("") ? 0.0f : Float.parseFloat(array[2]);
        float gravity = array[3].equals("") ? 0.0f : Float.parseFloat(array[3]);

        Galaxy type;

        if (array[5].equals("MODERN")) {
            type = Galaxy.MODERN;
        } else {
            if (array[5].equals("OLD")) {
                type = Galaxy.OLD;
            } else {
                type = Galaxy.ANCIENT;
            }
        }

        StringBuilder html = new StringBuilder();

        for (int i = 6; i < array.length; i++) {
            if (i == 6) html.append("[").append(array[i]).append(", ");
            else if (i == 8) html.append(array[i]).append("]");
            else html.append(array[i]).append(", ");
        }

        return new Planet(array[0], array[1].equals("true"), temp, gravity, array[4], type, html.toString());
    }
}