package businesslogic;

import businesslogic.entities.Planet;
import businesslogic.entities.SpaceObject;

import java.util.ArrayList;

public class Traveller {
    private Planet currentPlanet;
    private String name;

    Traveller(String name, Planet currentPlanet) {
        this.name = name;
        this.currentPlanet = currentPlanet;
    }

    public void setName(String name) {
        this.name = name;
    }

    ArrayList<SpaceObject> searchForTraveling(PlanetarySystem planetarySystem) {
        ArrayList<SpaceObject> tmp = new ArrayList<SpaceObject>();
        for (SpaceObject planet : planetarySystem.getPlanets()) {
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

    public boolean moveToOtherGate(Planet planet) {
        StarGate stargate = currentPlanet.getStargate();
        if (stargate == null) return false;
        if (!stargate.isActivated()) return false;

        stargate.activate();
        try {
            stargate.powerLend(planet);
            this.currentPlanet = planet;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}