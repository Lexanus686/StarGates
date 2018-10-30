package businesslogic;

import java.util.ArrayList;

public class SolarBuilder implements PlanetarySystemBuilder {

    private String name;
    private Integer numberOfPlanets = 8;
    private ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();
    private Galaxy galaxyType;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpaceObjects(int number) {
        this.numberOfPlanets = number;
    }

    @Override
    public void setGalaxyType(Galaxy galaxyType) {
        this.galaxyType = galaxyType;
        for (int i = 0; i < spaceObjects.size(); i++) {
            spaceObjects.get(i).setLocation(galaxyType);
        }
    }

    @Override
    public Galaxy getGalaxyType() {
        return this.galaxyType;
    }

    @Override
    public void addPlanetarySystemObject(SpaceObject obj) {
        spaceObjects.add(obj);
        if (this.numberOfPlanets >= 8) this.numberOfPlanets++;
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
        for (int i = 0; i < numberOfPlanets; i++) {

            spaceObjects.add(new Planet("Mercury", false, 273, 5.3f, "An"));
            spaceObjects.add(new Planet("Venus", false, 189, 8.3f, "Bn"));
            spaceObjects.add(new Planet("Earth", true, 15, 9.8f, "Cn"));
            spaceObjects.add(new Planet("Mars", true, -38, 4.2f, "Dn"));
            spaceObjects.add(new Planet("Jupiter", false, -115, 19.2f, "En"));
            spaceObjects.add(new Planet("Saturn", false, -98, 18.4f, "Fn"));
            spaceObjects.add(new Planet("Uranus", false, -164, 13.5f, "Gn"));
            spaceObjects.add(new Planet("Neptune", false, -183, 14.0f, "Hn"));
        }
    }

    public PlanetarySystem getResult() {
        return new PlanetarySystem(this.name, this.spaceObjects, this.galaxyType);
    }
}
