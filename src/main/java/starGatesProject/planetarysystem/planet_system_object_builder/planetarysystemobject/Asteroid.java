package starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject;

import starGatesProject.planetarysystem.planet_system_object_builder.mainclasses.StarGate;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;

public class Asteroid extends PlanetarySystemObject {

    Asteroid(String name, boolean isAvailableToVisit) {
        super(name, isAvailableToVisit, -273.15f, 0f, null);
    }

    @Override
    public boolean isAvailableToVisit() {
        return isAvailableToVisit;
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
