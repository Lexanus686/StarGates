package businesslogic;

public class Planet extends SpaceObject {

    public Planet(String planetName, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, String stargateName) {
        super(planetName, isAvailableToVisit, averageTemperature, gravitationPower, new StarGate(stargateName));

    }

    //добавление страны и учет возможности жить на планете
    public boolean addCountry(String name, String formOfGoverment, Location location, String race, boolean peacefulness) {

        return true;
    }

    @Override
    public boolean isAvailableToVisit() {
        return this.isAvailableToVisit;
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
}