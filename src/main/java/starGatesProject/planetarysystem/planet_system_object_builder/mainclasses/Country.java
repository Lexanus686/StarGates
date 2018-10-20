package starGatesProject.planetarysystem.planet_system_object_builder.mainclasses;

import java.util.ArrayList;

public class Country {
    private String countryName;
    private String formOfGovernment;
    private Location location;
    private ArrayList<String> raceNames;
    private boolean isPeacefull;

    public Country(String countryName, String formOfGovernment, Location location, String race, boolean peacefulness) {
        this.countryName = countryName;
        this.formOfGovernment = formOfGovernment;
        this.location = location;
        this.raceNames = new ArrayList<String>();
        this.raceNames.add(race);
        this.isPeacefull = peacefulness;
    }

    //добавление рас
    boolean addRace(String race) {
        this.raceNames.add(race);
        return true;
    }

    ArrayList<String> getRaces() {
        return raceNames;
    }

    boolean isPeaceful() {
        return this.isPeacefull;
    }

    public String getCountryName() {
        return this.countryName;
    }
}