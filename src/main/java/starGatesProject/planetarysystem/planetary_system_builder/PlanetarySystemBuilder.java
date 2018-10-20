package starGatesProject.planetarysystem.planetary_system_builder;

import starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject.PlanetarySystemObject;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;

public interface PlanetarySystemBuilder {
    void setName(String name);

    void setPlanetarySystemObjects(int number);

    void setGalaxyType(Galaxy galaxyType);

    Galaxy getGalaxyType();

    void addPlanetarySystemObject(PlanetarySystemObject obj);

    boolean removePlanetarySystemObject(String planetName);

    void buildPlanets();
}
