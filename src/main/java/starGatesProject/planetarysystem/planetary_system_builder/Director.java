package starGatesProject.planetarysystem.planetary_system_builder;

import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;

import java.util.Random;
import java.util.UUID;

//TODO доделать реализацию систем
public class Director {
    public void constructSolarSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        planetarySystemBuilder.setName("Solar System");
        planetarySystemBuilder.setPlanetarySystemObjects(8);
        planetarySystemBuilder.buildPlanets();
        planetarySystemBuilder.setGalaxyType(Galaxy.MODERN);
    }

    public void constructRandomSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        planetarySystemBuilder.setName(UUID.randomUUID().toString());
        planetarySystemBuilder.setPlanetarySystemObjects(new Random().nextInt(18));
    }


    public void constructCustomisedSystem(PlanetarySystemBuilder planetarySystemBuilder) {
        //planetarySystemBuilder.setName();
    }
}
