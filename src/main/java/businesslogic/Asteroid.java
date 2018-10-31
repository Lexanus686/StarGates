package businesslogic;

public class Asteroid extends SpaceObject {

    Asteroid(String name, boolean isAvailableToVisit) {
        super(name, isAvailableToVisit, -273.15f, 0f, null);
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
}
