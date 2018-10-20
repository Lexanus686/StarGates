package starGatesProject.person;

import starGatesProject.planetarysystem.planet_system_object_builder.mainclasses.StarGate;
import starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject.Planet;
import starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject.PlanetarySystemObject;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.PlanetarySystem;

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

    ArrayList<PlanetarySystemObject> searchForTraveling(PlanetarySystem planetarySystem) {
        ArrayList<PlanetarySystemObject> tmp = new ArrayList<PlanetarySystemObject>();
        for (PlanetarySystemObject planet : planetarySystem.getPlanets()) {
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