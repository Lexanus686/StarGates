package starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject;

import starGatesProject.planetarysystem.planet_system_object_builder.mainclasses.StarGate;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;

public class Sun extends PlanetarySystemObject {

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
