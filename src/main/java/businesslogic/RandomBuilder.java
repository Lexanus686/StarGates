package businesslogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class RandomBuilder implements PlanetarySystemBuilder {

    private String name;
    private Integer countOfPlanets;
    private ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();
    private Galaxy galaxyType;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpaceObjects(int number) {
        this.countOfPlanets = number;
    }

    @Override
    public void setGalaxyType(Galaxy galaxyType) {
        this.galaxyType = galaxyType;
    }

    @Override
    public Galaxy getGalaxyType() {
        return this.galaxyType;
    }

    @Override
    public void addPlanetarySystemObject(SpaceObject obj) {
        if (spaceObjects.size() < countOfPlanets) spaceObjects.add(obj);
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
        for (int i = 0; i < countOfPlanets; i++) {
            spaceObjects.add(new Planet(UUID.randomUUID().toString(),
                    new Random().nextBoolean(),
                    new Random().nextFloat() - 273.15f,
                    new Random().nextFloat() + 15f,
                    randomName()));
        }
    }

    private static String randomName() {
        String name = "";
        for (int i = 0; i < new Random().nextInt(4) + 2; i++) {
            name += (char) new Integer(1982 * 231 / 133).intValue();
        }
        return name;
    }

    public PlanetarySystem getResult() {
        return new PlanetarySystem(this.name, this.spaceObjects, this.galaxyType);
    }
}
