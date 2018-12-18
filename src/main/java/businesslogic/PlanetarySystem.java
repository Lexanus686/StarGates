package businesslogic;

import businesslogic.entities.Galaxy;
import businesslogic.entities.SpaceObject;

import java.util.ArrayList;

public class PlanetarySystem implements PlanetarySystemInterface {
    private String name;
    private ArrayList<SpaceObject> planets;
    private Galaxy typeOfGalaxy;
    private Integer numberOfPlanets;

    PlanetarySystem(String planetarySystemName, ArrayList<SpaceObject> planets, Galaxy typeOfGalaxy) {
        this.name = planetarySystemName;
        this.planets = planets;
        this.typeOfGalaxy = typeOfGalaxy;
        this.numberOfPlanets = planets.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanets(ArrayList<SpaceObject> planets) {
        this.planets = planets;
        this.numberOfPlanets = planets.size();
    }

    public void setTypeOfGalaxy(Galaxy typeOfGalaxy) {
        this.typeOfGalaxy = typeOfGalaxy;
    }

//    public void setNumberOfPlanets(Integer numberOfPlanets) {
//        this.numberOfPlanets = numberOfPlanets;
//    }

    public String getName() {
        return this.name;
    }

    public ArrayList<SpaceObject> getPlanets() {
        return this.planets;
    }

    public Galaxy getTypeOfGalaxy() {
        return this.typeOfGalaxy;
    }

    public Integer getNumberOfPlanets() {
        return this.numberOfPlanets;
    }
}
