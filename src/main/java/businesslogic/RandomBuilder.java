package businesslogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class RandomBuilder implements PlanetarySystemBuilder {

    private String name;
    private Integer countOfPlanets;
    private ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();
    private Galaxy galaxyType;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpaceObjects(int number) {
        this.countOfPlanets = number;
    }

    @Override
    public void setGalaxyType(Galaxy galaxyType) {
        this.galaxyType = galaxyType;
    }

    @Override
    public Galaxy getGalaxyType() {
        return this.galaxyType;
    }

    @Override
    public void addPlanetarySystemObject(SpaceObject obj) {
        if (spaceObjects.size() < countOfPlanets) spaceObjects.add(obj);
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
        for (int i = 0; i < countOfPlanets; i++) {
            spaceObjects.add(new Planet(UUID.randomUUID().toString(),
                    new Random().nextBoolean(),
                    new Random().nextFloat() - 273.15f,
                    new Random().nextFloat() + 15f,
                    randomName(), randomActivated(), randomLocation(), randomHTMLCode()));
        }
    }

    private static String randomName() {
        String name = "";
        for (int i = 0; i < new Random().nextInt(4) + 2; i++) {
            name += (char) new Integer(1982 * 231 / 133).intValue();
        }
        return name;
    }

    private static boolean randomActivated() {
        return new Random().nextInt(1000) % 2 == 1;
    }

    private static Galaxy randomLocation() {
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                return Galaxy.MODERN;
            case 1:
                return Galaxy.OLD;
            case 2:
                return Galaxy.ANCIENT;
            default:
                return null;
        }
    }

    private static String randomHTMLCode() {
        String tmp;

        tmp = "circle, ui-draggable ui-draggable-handle, background: rgb(" + Integer.toString(new Random().nextInt(256)) +
                "," + Integer.toString(new Random().nextInt(256)) + "," + Integer.toString(new Random().nextInt(256)) + "); position: relative; left: " +
                Integer.toString(new Random().nextInt(1280)) + "px; top:" + Integer.toString(new Random().nextInt(1280)) + "px;";

        return tmp;
    }

    public PlanetarySystem getResult() {
        return new PlanetarySystem(this.name, this.spaceObjects, this.galaxyType);
    }
}
