package businesslogic;

import java.util.ArrayList;

public class PlanetarySystem {
    private String name;
    private ArrayList<SpaceObject> planets;
    private Galaxy typeOfGalaxy;
    private Integer numberOfPlanets;

    public PlanetarySystem(String planetarySystemName, ArrayList<SpaceObject> planets, Galaxy typeOfGalaxy) {
        this.name = planetarySystemName;
        this.planets = planets;
        this.typeOfGalaxy = typeOfGalaxy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanets(ArrayList<SpaceObject> planets) {
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

    public ArrayList<SpaceObject> getPlanets() {
        return this.planets;
    }

    public Galaxy getTypeOfGalaxy() {
        return this.typeOfGalaxy;
    }

    public void info() {
        System.out.println(getName());
        System.out.println(getTypeOfGalaxy());
        System.out.println(getPlanets());
    }
}
