package businesslogic;

public class DirectorFacade {
    public PlanetarySystem createSystem(String value) {

        DirectorInterface director = new Director();

        if (value.equals("Solar")) {

            PlanetarySystemBuilder solarBuilder = new SolarBuilder();
            director.constructSolarSystem(solarBuilder);
            return solarBuilder.getResult();

        } else if (value.equals("Random")) {

            PlanetarySystemBuilder randomBuilder = new RandomBuilder();
            director.constructRandomSystem(randomBuilder);
            return randomBuilder.getResult();

        } else {

            PlanetarySystemBuilder customizedBuilder = new CustomizedBuilder();
            director.constructCustomisedSystem(customizedBuilder);
            return customizedBuilder.getResult();

        }
    }

}
