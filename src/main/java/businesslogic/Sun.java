package businesslogic;

public class Sun extends SpaceObject {

    Sun(String name, float averageTemperature, float gravitationPower) {
        super(name, false, averageTemperature, gravitationPower, null);
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
    public boolean isAvailableToVisit() {
        return false;
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
