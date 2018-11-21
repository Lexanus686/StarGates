package businesslogic;

import java.util.ArrayList;

public class SolarBuilder implements PlanetarySystemBuilder {

    private final String ID = "circle, ";
    private final String CLASS_NAME = "ui-draggable ui-draggable-handle, ";
    private final String BACKGROUND = "background: rgb(";
    private final String POSITION = "position: relative; ";

    private final String MERCURY_HTML = ID + CLASS_NAME + BACKGROUND + "10,10,10" + "); " + POSITION + "top: 100px; left: 50px;";
    private final String VENUS_HTML = ID + CLASS_NAME + BACKGROUND + "20,20,20" + "); " + POSITION + "top: 100px; left: 100px;";
    private final String EARTH_HTML = ID + CLASS_NAME + BACKGROUND + "30,30,30" + "); " + POSITION + "top: 100px; left: 150px;";
    private final String MARS_HTML = ID + CLASS_NAME + BACKGROUND + "40,40,40" + "); " + POSITION + "top: 100px; left: 200px;";
    private final String JUPITER_HTML = ID + CLASS_NAME + BACKGROUND + "50,50,50" + "); " + POSITION + "top: 100px; left: 250px;";
    private final String SATURN_HTML = ID + CLASS_NAME + BACKGROUND + "60,60,60" + "); " + POSITION + "top: 100px; left: 300px;";
    private final String URANUS_HTML = ID + CLASS_NAME + BACKGROUND + "70,70,70" + "); " + POSITION + "top: 100px; left: 350px;";
    private final String NEPTUNE_HTML = ID + CLASS_NAME + BACKGROUND + "80,80,80" + "); " + POSITION + "top: 100px; left: 400px;";

    private String name;
    private Integer numberOfPlanets;
    private ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();
    private Galaxy galaxyType;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpaceObjects(int number) {
        this.numberOfPlanets = number;
    }

    @Override
    public void setGalaxyType(Galaxy galaxyType) {
        this.galaxyType = galaxyType;
        for (int i = 0; i < spaceObjects.size(); i++) {
            spaceObjects.get(i).setLocation(galaxyType);
        }
    }

    @Override
    public Galaxy getGalaxyType() {
        return this.galaxyType;
    }

    @Override
    public void addPlanetarySystemObject(SpaceObject obj) {
        spaceObjects.add(obj);
        if (this.numberOfPlanets >= 8) this.numberOfPlanets++;
    }

    @Override
    public boolean removePlanetarySystemObject(String planetName) {
        for (SpaceObject planet : spaceObjects) {
            if (planet.getPlanetaryObjectName().equalsIgnoreCase(planetName)) {
                spaceObjects.remove(planet);
                return true;
            }
        }
        return false;
    }

    @Override
    public void buildPlanets() {
        spaceObjects.add(new Planet("Mercury", false, 273, 5.3f, "An", false, Galaxy.MODERN, MERCURY_HTML));
        spaceObjects.add(new Planet("Venus", false, 189, 8.3f, "Bn", false, Galaxy.MODERN, VENUS_HTML));
        spaceObjects.add(new Planet("Earth", true, 15, 9.8f, "Cn", true, Galaxy.MODERN, EARTH_HTML));
        spaceObjects.add(new Planet("Mars", true, -38, 4.2f, "Dn", false, Galaxy.MODERN, MARS_HTML));
        spaceObjects.add(new Planet("Jupiter", false, -115, 19.2f, "En", false, Galaxy.MODERN, JUPITER_HTML));
        spaceObjects.add(new Planet("Saturn", false, -98, 18.4f, "Fn", false, Galaxy.MODERN, SATURN_HTML));
        spaceObjects.add(new Planet("Uranus", false, -164, 13.5f, "Gn", false, Galaxy.MODERN, URANUS_HTML));
        spaceObjects.add(new Planet("Neptune", false, -183, 14.0f, "Hn", false, Galaxy.MODERN, NEPTUNE_HTML));
    }

    public PlanetarySystem getResult() {
        return new PlanetarySystem(this.name, this.spaceObjects, this.galaxyType);
    }
}
