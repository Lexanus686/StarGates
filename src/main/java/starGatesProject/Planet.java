package starGatesProject;

import java.util.ArrayList;

public class Planet {
    private String planetName; //название планеты
    private boolean isAvailableToVisit; //возможность посещения человеческой расой
    private ArrayList<Country> countries; //массив стран, существующих на планете
    private float averageTemperature; //средняя температура
    private float gravitationPower; //сила гравитации (в g)
    private StarGate stargate;

    Planet(String planetName, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, String stargateName) {
        this.planetName = planetName;
        this.isAvailableToVisit = isAvailableToVisit;
        this.countries = new ArrayList<Country>();
        this.averageTemperature = averageTemperature;
        this.gravitationPower = gravitationPower;
        this.stargate = new StarGate(stargateName);
    }

    //добавление страны и учет возможности жить на планете
    boolean addCountry(String name, String formOfGoverment, Location location, String race, boolean peacefulness) {
        countries.add(new Country(name, formOfGoverment, location, race, peacefulness));
        return true;
    }

    /*return'ы*/
    boolean isAvailableToVisit() {
        return this.isAvailableToVisit;
    }

    ArrayList<Country> getCountries() {
        return this.countries;
    }

    String getPlanetName() {
        return this.planetName;
    }

    boolean getInhabbitance() {
        return countries.size() != 0;
    }
}