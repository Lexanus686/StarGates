package businesslogic;

public interface DirectorInterface {
    void constructSolarSystem(PlanetarySystemBuilder planetarySystemBuilder);

    void constructRandomSystem(PlanetarySystemBuilder planetarySystemBuilder);

    void constructCustomisedSystem(PlanetarySystemBuilder planetarySystemBuilder);
}
