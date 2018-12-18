package UI.controller;

import businesslogic.*;
import businesslogic.entities.Galaxy;
import businesslogic.entities.Planet;
import businesslogic.entities.SpaceObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainPageController {

    private PlanetManagerInterface planetManager = null;

    @RequestMapping(value = "/updatePlanet", method = RequestMethod.GET)
    public @ResponseBody
    Integer updatePlanet(@RequestParam(value = "myHTMLArray[]") String[] htmlelements) {

        if (htmlelements[1].length() < 4)
            planetManager.updatePlanets(errorElement(htmlelements));
        else planetManager.updatePlanets(htmlelements);

        return 33;
    }

    @RequestMapping(value = "/getPlanetSystem", method = RequestMethod.GET)
    public @ResponseBody
    Integer getPlanetSystem(@RequestParam(value = "myString") String myString) {

        DirectorFacade directorFacade = new DirectorFacade();

        PlanetarySystemInterface planetarySystem = directorFacade.createSystem(myString);

        ArrayList<SpaceObject> tmp = ((PlanetarySystem) planetarySystem).getPlanets();

        for (int i = 0; i < ((PlanetarySystem) planetarySystem).getNumberOfPlanets(); i++) {
            addPlanet(convertToStringArray(tmp.get(i)));
        }

        return 23;
    }

    //tmp
    @RequestMapping(value = "/loader", method = RequestMethod.GET)
    public @ResponseBody
    Integer sendNotify(@RequestParam(value = "sign") Integer sign) {
        return 0;
    }

    @RequestMapping(value = "/addPlanet", method = RequestMethod.GET)
    public @ResponseBody
    Integer addPlanet(@RequestParam(value = "myArray[]") String[] myArray) {
        SpaceObject planet = initPlanet(myArray);
        planetManager.addPlanet(planet);

        return 13;
    }

    @RequestMapping(value = "/getAllPlanets", method = RequestMethod.GET)
    public @ResponseBody
    String[] getAllPlanets(@RequestParam(value = "myMessage") String myMessage) {
        //тут запуск чего-то, связанного с асинхронным обращением к БД

        return getStrings(planetManager.getAllPlanets());
    }

    @GetMapping("/mainpage")
    public String mainPageForm(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        planetManager = new PlanetManager();

        model.addAttribute("main", mainpage);
        return "mainpage";
    }

    @PostMapping("/mainpage")
    public String mainPagePost(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        model.addAttribute("main", mainpage);
        return "mainpage";
    }

    private static Planet initPlanet(String[] array) {

        float temp = array[2].equals("") ? 0.0f : Float.parseFloat(array[2]);
        float gravity = array[3].equals("") ? 0.0f : Float.parseFloat(array[3]);

        Galaxy type;

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

    private String[] getStrings(ArrayList<SpaceObject> allPlanets) {
        String[] tmp = new String[allPlanets.size()];
        for (int i = 0; i < allPlanets.size(); i++) {
            tmp[i] = allPlanets.get(i).getPlanetaryObjectName() + " " + allPlanets.get(i).isAvailableToVisit() + " " +
                    allPlanets.get(i).getAverageTemperature() + " " + allPlanets.get(i).getGravitationPower() + " " +
                    allPlanets.get(i).getStargate().getName() + " " + allPlanets.get(i).getStargate().isActivated() + " " +
                    allPlanets.get(i).getLocation() + " " + allPlanets.get(i).getHtmlInfo();
        }
        return tmp;
    }

    private static String[] errorElement(String[] htmlelements) {
        String[] tmp = new String[1];
        tmp[0] = htmlelements[0] + "," + htmlelements[1] + "," + htmlelements[2];

        return tmp;
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