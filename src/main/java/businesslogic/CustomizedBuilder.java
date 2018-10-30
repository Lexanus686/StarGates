package businesslogic;

import java.util.ArrayList;

//Пользовтель с помощью формы сам будет выбирать, что ему строить
public class CustomizedBuilder implements PlanetarySystemBuilder {

    private String name;
    private Integer number;
    private ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();
    private Galaxy galaxyType;

    @Override
    public Galaxy getGalaxyType() {
        return this.galaxyType;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpaceObjects(int number) {
        this.number = number;
    }

    @Override
    public void setGalaxyType(Galaxy galaxyType) {
        this.galaxyType = galaxyType;
    }

    @Override
    public void addPlanetarySystemObject(SpaceObject obj) {
        spaceObjects.add(obj);
    }

    @Override
    public boolean removePlanetarySystemObject(String planetName) {
        for (SpaceObject planet : spaceObjects) {
            if (planet.getPlanetaryObjectName().equalsIgnoreCase(planetName)) {
                spaceObjects.remove(planet);
                return true;
            }
        }
        return false;
    }

    @Override
    public void buildPlanets() {

    }

    public PlanetarySystem getResult() {
        return new PlanetarySystem(this.name, this.spaceObjects, this.galaxyType);
    }
}
