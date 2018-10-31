package businesslogic;

public interface PlanetarySystemBuilder {
    void setName(String name);

    void setSpaceObjects(int number);

    void setGalaxyType(Galaxy galaxyType);

    void buildPlanets();

    Galaxy getGalaxyType();

    void addPlanetarySystemObject(SpaceObject obj);

    boolean removePlanetarySystemObject(String planetName);
}
