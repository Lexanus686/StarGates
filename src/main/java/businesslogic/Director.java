package businesslogic;

import java.util.Random;
import java.util.UUID;

//TODO доделать реализацию систем
public class Director {
    public void constructSolarSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        planetarySystemBuilder.setName("Solar System");
        planetarySystemBuilder.setSpaceObjects(8);
        planetarySystemBuilder.buildPlanets();
        planetarySystemBuilder.setGalaxyType(Galaxy.MODERN);
    }

    public void constructRandomSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        planetarySystemBuilder.setName(UUID.randomUUID().toString());
        planetarySystemBuilder.setSpaceObjects(new Random().nextInt(18) + 1);
        planetarySystemBuilder.buildPlanets();
        int random = new Random().nextInt(2) + 1;
        planetarySystemBuilder.setGalaxyType((random == 0) ? (Galaxy.MODERN) : ((random == 1) ? (Galaxy.ANCIENT) : (Galaxy.OLD)));
    }


    public void constructCustomisedSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        //planetarySystemBuilder.setName();
    }
}
