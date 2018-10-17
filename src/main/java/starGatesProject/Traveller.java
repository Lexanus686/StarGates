package starGatesProject;

import java.util.ArrayList;

public class Traveller {
    private Planet currentPlanet;
    private String name;

    Traveller(String name, Planet currentPlanet) {
        this.name = name;
        this.currentPlanet = currentPlanet;
    }

    ArrayList<Planet> searchForTraveling(PlanetarySystem planetarySystem) {
        ArrayList<Planet> tmp = new ArrayList<Planet>();
        for (Planet planet : planetarySystem.getNumberOfPlanets()) {
            if (planet.isAvailableToVisit()) {
                tmp.add(planet);
            }
        }
        return tmp;
    }

    //возможность перемещения на другую планету
    boolean moveToOtherPlanet(Planet planet) {
        if (planet.isAvailableToVisit()) {
            this.currentPlanet = planet;
            return true;
        } else return false;
    }

    Planet getLocation() {
        return this.currentPlanet;
    }

    public boolean moveToOtherGate(StarGate stargate) {
        /*if (!stargate.hasStub()) return true;
        if (!stargate.isActivated()) return false;*/


        return true;
    }
}