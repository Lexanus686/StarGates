package starGatesProject.planetarysystem.planetary_system_builder;

import starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject.Planet;
import starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject.PlanetarySystemObject;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.PlanetarySystem;

import java.util.ArrayList;

public class SolarBuilder implements PlanetarySystemBuilder {

    private String name;
    private Integer numberOfPlanets = 8;
    private ArrayList<PlanetarySystemObject> planetarySystemObjects = new ArrayList<PlanetarySystemObject>();
    private Galaxy galaxyType;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPlanetarySystemObjects(int number) {
        this.numberOfPlanets = number;
    }

    @Override
    public void setGalaxyType(Galaxy galaxyType) {
        this.galaxyType = galaxyType;
        for (int i = 0; i < planetarySystemObjects.size(); i++) {
            planetarySystemObjects.get(i).setLocation(galaxyType);
        }
    }

    @Override
    public Galaxy getGalaxyType() {
        return this.galaxyType;
    }

    @Override
    public void addPlanetarySystemObject(PlanetarySystemObject obj) {

    }

    @Override
    public boolean removePlanetarySystemObject(String planetName) {
        for (PlanetarySystemObject planet : planetarySystemObjects) {
            if (planet.getPlanetaryObjectName().equalsIgnoreCase(planetName)) {
                planetarySystemObjects.remove(planet);
                return true;
            }
        }
        return false;
    }

    @Override
    public void buildPlanets() {
        for (int i = 0; i < numberOfPlanets; i++) {

            planetarySystemObjects.add(new Planet("Mercury", false, 273, 5.3f, "An"));
            planetarySystemObjects.add(new Planet("Venus", false, 189, 8.3f, "Bn"));
            planetarySystemObjects.add(new Planet("Earth", true, 15, 9.8f, "Cn"));
            planetarySystemObjects.add(new Planet("Mars", true, -38, 4.2f, "Dn"));
            planetarySystemObjects.add(new Planet("Jupiter", false, -115, 19.2f, "En"));
            planetarySystemObjects.add(new Planet("Saturn", false, -98, 18.4f, "Fn"));
            planetarySystemObjects.add(new Planet("Uranus", false, -164, 13.5f, "Gn"));
            planetarySystemObjects.add(new Planet("Neptune", false, -183, 14.0f, "Hn"));
        }
    }

    public PlanetarySystem getResult() {
        return new PlanetarySystem(this.name, this.planetarySystemObjects, this.galaxyType);
    }
}
