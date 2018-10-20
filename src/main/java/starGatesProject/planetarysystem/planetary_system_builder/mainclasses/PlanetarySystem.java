package starGatesProject.planetarysystem.planetary_system_builder.mainclasses;

import starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject.PlanetarySystemObject;

import java.util.ArrayList;

public class PlanetarySystem {
    private String name;
    private ArrayList<PlanetarySystemObject> planets;
    private Galaxy typeOfGalaxy;
    private Integer numberOfPlanets;

    public PlanetarySystem(String planetarySystemName, ArrayList<PlanetarySystemObject> planets, Galaxy typeOfGalaxy) {
        this.name = planetarySystemName;
        this.planets = planets;
        this.typeOfGalaxy = typeOfGalaxy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanets(ArrayList<PlanetarySystemObject> planets) {
        this.planets = planets;
    }

    public void setTypeOfGalaxy(Galaxy typeOfGalaxy) {
        this.typeOfGalaxy = typeOfGalaxy;
    }

    public void setNumberOfPlanets(Integer numberOfPlanets) {
        this.numberOfPlanets = numberOfPlanets;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<PlanetarySystemObject> getPlanets() {
        return this.planets;
    }

    public Galaxy getTypeOfGalaxy() {
        return this.typeOfGalaxy;
    }
}
