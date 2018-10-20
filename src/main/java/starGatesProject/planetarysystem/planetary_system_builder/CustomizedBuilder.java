package starGatesProject.planetarysystem.planetary_system_builder;

import starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject.PlanetarySystemObject;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.PlanetarySystem;

import java.util.ArrayList;

//Пользовтель с помощью формы сам будет выбирать, что ему строить
public class CustomizedBuilder implements PlanetarySystemBuilder {

    private String name;
    private Integer number;
    private ArrayList<PlanetarySystemObject> planetarySystemObjects = new ArrayList<PlanetarySystemObject>();
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
    public void setPlanetarySystemObjects(int number) {
        this.number = number;
    }

    @Override
    public void setGalaxyType(Galaxy galaxyType) {
        this.galaxyType = galaxyType;
    }

    @Override
    public void addPlanetarySystemObject(PlanetarySystemObject obj) {
        planetarySystemObjects.add(obj);
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

    }

    public PlanetarySystem getResult() {
        return new PlanetarySystem(this.name, this.planetarySystemObjects, this.galaxyType);
    }
}
