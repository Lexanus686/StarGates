package businesslogic;

import businesslogic.entities.Galaxy;

import java.util.Random;
import java.util.UUID;

public class Director implements DirectorInterface {
    @Override
    public void constructSolarSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        planetarySystemBuilder.setName("Solar System");
        planetarySystemBuilder.setSpaceObjects(8);
        planetarySystemBuilder.buildPlanets();
        planetarySystemBuilder.setGalaxyType(Galaxy.MODERN);
    }

    @Override
    public void constructRandomSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        planetarySystemBuilder.setName(UUID.randomUUID().toString());
        planetarySystemBuilder.setSpaceObjects(new Random().nextInt(18) + 1);
        planetarySystemBuilder.buildPlanets();
        int random = new Random().nextInt(2) + 1;
        planetarySystemBuilder.setGalaxyType((random == 0) ? (Galaxy.MODERN) : ((random == 1) ? (Galaxy.ANCIENT) : (Galaxy.OLD)));
    }

    @Override
    public void constructCustomisedSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        //TODO допилить реализацию. Пусть тут user сам задает, что он хочет построить
    }
}
