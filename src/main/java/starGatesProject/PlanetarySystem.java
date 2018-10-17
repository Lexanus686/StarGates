package starGatesProject;

import java.util.ArrayList;

public class PlanetarySystem {
    private String name;
    private ArrayList<Planet> planets;
    private Location locationOfSystem;
    private Galaxy typeOfGalaxy;

    public PlanetarySystem(String planetarySystemName, Location locationOfSystem) {
        this.name = planetarySystemName;
        this.locationOfSystem = locationOfSystem;
        this.planets = new ArrayList<Planet>();
    }

    //добавление планеты в планетарную систему через непосредственное создание
    // (считаем, что размер inf)
    void addPlanet(String planetName, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, boolean isInhabitated) {
        this.planets.add(new Planet(planetName, isAvailableToVisit, averageTemperature, gravitationPower, "kellel"));
    }

    //Добавление планеты, как уже созданного объекта
    void addPlanet(Planet obj) {
        planets.add(obj);
    }

    //"уничтожение" планеты из планетарной системы
    boolean removePlanet(String planetName) {
        for (Planet planet : planets) {
            if (planet.getPlanetName().equalsIgnoreCase(planetName)) {
                planets.remove(planet);
                return true;
            }
        }
        return false;
    }

    ArrayList<Planet> getNumberOfPlanets() {
        return this.planets;
    }
}
