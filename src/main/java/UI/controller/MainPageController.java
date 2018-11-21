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

        return 3;
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
        return 2;
    }

    @RequestMapping(value = "/getPlanet", method = RequestMethod.GET)
    public @ResponseBody
    Integer getPlanet(@RequestParam(value = "myArray[]") String[] myArray) {
        Planet planet = getinit(myArray);
        planetManager.addPlanet(planet);
        //planet.info();
        return 1;
    }

    @GetMapping("/mainpage")
    public String mainPageForm(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        planetManager = new PlanetManagerAbstract();
        ArrayList<Planet> allPlanets = planetManager.getAllPlanets();
        //for test
//        for (Planet item: allPlanets)
//            item.info();

        //TODO реализовать загрузку всех планет на сайт, как только user войдет на страницу

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

        String html = "";

        for (int i = 6; i < array.length; i++) {
            html += array[i];
        }

        Planet tmp = new Planet(array[0], array[1].equals("true"), temp, gravity, array[4], type, html);

        return tmp;
    }
}