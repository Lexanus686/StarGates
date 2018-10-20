package starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject;


import starGatesProject.planetarysystem.planet_system_object_builder.mainclasses.Country;
import starGatesProject.planetarysystem.planet_system_object_builder.mainclasses.Location;
import starGatesProject.planetarysystem.planet_system_object_builder.mainclasses.StarGate;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;

import java.util.ArrayList;

public class Planet extends PlanetarySystemObject {
    private ArrayList<Country> countries; //массив стран, существующих на планете

    public Planet(String planetName, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, String stargateName) {
        super(planetName, isAvailableToVisit, averageTemperature, gravitationPower, new StarGate(stargateName));
        this.countries = new ArrayList<Country>();
    }

    //добавление страны и учет возможности жить на планете
    public boolean addCountry(String name, String formOfGoverment, Location location, String race, boolean peacefulness) {
        countries.add(new Country(name, formOfGoverment, location, race, peacefulness));
        return true;
    }

    @Override
    public boolean isAvailableToVisit() {
        return this.isAvailableToVisit;
    }

    @Override
    public void setLocation(Galaxy location) {
        super.location = location;
    }

    @Override
    public Galaxy getLocation() {
        return super.location;
    }

    @Override
    public String getPlanetaryObjectName() {
        return super.name;
    }

    @Override
    public StarGate getStargate() {
        return super.starGate;
    }
}