package businesslogic;

import businesslogic.entities.Galaxy;
import businesslogic.entities.SpaceObject;

public interface PlanetarySystemBuilder {
    void setName(String name);

    void setSpaceObjects(int number);

    void setGalaxyType(Galaxy galaxyType);

    void buildPlanets();

    PlanetarySystem getResult();

    Galaxy getGalaxyType();

    void addPlanetarySystemObject(SpaceObject obj);

    boolean removePlanetarySystemObject(String planetName);
}
