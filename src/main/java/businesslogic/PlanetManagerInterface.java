package businesslogic;

import businesslogic.entities.SpaceObject;

import java.util.ArrayList;

public interface PlanetManagerInterface {
    SpaceObject getPlanet(SpaceObject planet);

    void addPlanet(SpaceObject planet);

    void updatePlanets(String[] htmlelements);

    ArrayList<SpaceObject> getAllPlanets();
}
