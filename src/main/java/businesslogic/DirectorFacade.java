package businesslogic;

import UI.ProgressBarListenerInterface;
import UI.controller.MainPageController;
import businesslogic.entities.SpaceObject;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static businesslogic.entities.Planet.initPlanet;

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

    //TODO rename method
    public Future<Integer> LoaderwithProgress(final ProgressBarListenerInterface listener, final PlanetarySystem planetarySystem, final MainPageController controller, final PlanetManagerInterface planetManager) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> callable = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws InterruptedException {

                float diff = (float) 1 / planetarySystem.getNumberOfPlanets() * 100;
                ArrayList<SpaceObject> array = planetarySystem.getPlanets();

                for (int i = 0; i < planetarySystem.getNumberOfPlanets(); i++) {
                    System.out.println(String.format("I: %d", i + 1));
                    planetManager.addPlanet(initPlanet(convertToStringArray(array.get(i))));
//                    System.out.println("Planet:" + Arrays.toString(convertToStringArray(array.get(i))));

                    listener.update(controller, diff);

                    Thread.sleep(1000);
                }
                return 0;
            }
        });
        executor.shutdown();
        return callable;
    }

    private static String[] convertToStringArray(SpaceObject obj) {
        String[] tmp = new String[7];
        tmp[0] = obj.getPlanetaryObjectName();
        tmp[1] = String.valueOf(obj.isAvailableToVisit());
        tmp[2] = String.valueOf(obj.getAverageTemperature());
        tmp[3] = String.valueOf(obj.getGravitationPower());
        tmp[4] = obj.getStargate().getName();
        tmp[5] = obj.getLocation().name();
        tmp[6] = obj.getHtmlInfo();
        return tmp;
    }
}
