package UI.controller;

import businesslogic.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainPageController {

    private PlanetManagerAbstract planetManager = null;

    @RequestMapping(value = "/updatePlanet", method = RequestMethod.GET)
    public @ResponseBody
    Integer updatePlanet(@RequestParam(value = "myHTMLArray[]") String[] htmlelements) {

        if (htmlelements[1].length() < 4)
            planetManager.updatePlanets(errorElement(htmlelements));
        else planetManager.updatePlanets(htmlelements);

        return 33;
    }

    private static String[] errorElement(String[] htmlelements) {
        String[] tmp = new String[1];
        tmp[0] = htmlelements[0] + "," + htmlelements[1] + "," + htmlelements[2];

        return tmp;
    }

    @RequestMapping(value = "/getPlanetSystem", method = RequestMethod.GET)
    public @ResponseBody
    Integer getPlanetSystem(@RequestParam(value = "myString") String myString) {
        Director director = new Director();
        if (myString.equals("Solar")) {
            SolarBuilder solarBuilder = new SolarBuilder();
            director.constructSolarSystem(solarBuilder);
            PlanetarySystem current = solarBuilder.getResult();
            //current.info();
        } else if (myString.equals("Random")) {
            RandomBuilder randomBuilder = new RandomBuilder();
            director.constructRandomSystem(randomBuilder);
            PlanetarySystem current = randomBuilder.getResult();
            //current.info();
        }
        return 23;
    }

    @RequestMapping(value = "/addPlanet", method = RequestMethod.GET)
    public @ResponseBody
    Integer addPlanet(@RequestParam(value = "myArray[]") String[] myArray) {
        Planet planet = getinit(myArray);
        planetManager.addPlanet(planet);
        //planet.info();
        return 13;
    }

    @RequestMapping(value = "/getAllPlanets", method = RequestMethod.GET)
    public @ResponseBody
    String[] getAllPlanets(@RequestParam(value = "myMessage") String myMessage) {
        ArrayList<Planet> allPlanets = planetManager.getAllPlanets();

        String[] tmp = new String[allPlanets.size()];
        for (int i = 0; i < allPlanets.size(); i++) {
            tmp[i] = allPlanets.get(i).getPlanetaryObjectName() + " " + allPlanets.get(i).isAvailableToVisit() + " " +
                    allPlanets.get(i).getAverageTemperature() + " " + allPlanets.get(i).getGravitationPower() + " " +
                    allPlanets.get(i).getStargate().getName() + " " + allPlanets.get(i).getStargate().isActivated() + " " +
                    allPlanets.get(i).getLocation() + " " + allPlanets.get(i).getHtmlInfo();
        }

        return tmp;
    }

    @GetMapping("/mainpage")
    public String mainPageForm(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        planetManager = new PlanetManagerAbstract();

        model.addAttribute("main", mainpage);
        return "mainpage";
    }

    @PostMapping("/mainpage")
    public String mainPagePost(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        model.addAttribute("main", mainpage);
        return "mainpage";
    }

    private static Planet getinit(String[] array) {

        float temp = array[2].equals("") ? 0.0f : Float.parseFloat(array[2]);
        float gravity = array[3].equals("") ? 0.0f : Float.parseFloat(array[3]);

        Galaxy type = null;

        if (array[5].equals("MODERN")) {
            type = Galaxy.MODERN;
        } else {
            if (array[5].equals("OLD")) {
                type = Galaxy.OLD;
            } else {
                type = Galaxy.ANCIENT;
            }
        }

        StringBuilder html = new StringBuilder();

        for (int i = 6; i < array.length; i++) {
            if (i == 6) html.append("[").append(array[i]).append(", ");
            else if (i == 8) html.append(array[i]).append("]");
            else html.append(array[i]).append(", ");
        }

        return new Planet(array[0], array[1].equals("true"), temp, gravity, array[4], type, html.toString());
    }
}