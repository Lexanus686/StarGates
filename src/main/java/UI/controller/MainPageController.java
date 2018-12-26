package UI.controller;

import UI.ProgressBarListener;
import UI.ProgressBarListenerInterface;
import businesslogic.DirectorFacade;
import businesslogic.PlanetManager;
import businesslogic.PlanetManagerInterface;
import businesslogic.PlanetarySystem;
import businesslogic.entities.SpaceObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.Future;

import static businesslogic.entities.Planet.initPlanet;

@Controller
public class MainPageController {

    private PlanetManagerInterface planetManager = null;

    @RequestMapping(value = "/updatePlanet", method = RequestMethod.GET)
    public @ResponseBody
    Integer updatePlanet(@RequestParam(value = "myHTMLArray[]") String[] htmlelements) {
        if (planetManager != null)
            if (htmlelements[1].length() < 4)
                planetManager.updatePlanets(errorElement(htmlelements));
            else planetManager.updatePlanets(htmlelements);

        return 33;
    }

    @RequestMapping(value = "/updateRetrive", method = RequestMethod.POST)
    public @ResponseBody
    Integer updateRetrive() {

        return 142;
    }

    @RequestMapping(value = "/updateProgressBar", method = RequestMethod.POST)
    public @ResponseBody
    Float updateProgressBar(@RequestParam(value = "percent") float current) {
        System.out.println(current + "%");
        return current;
    }

    @RequestMapping(value = "/getPlanetSystem", method = RequestMethod.GET)
    public @ResponseBody
    Integer getPlanetSystem(@RequestParam(value = "myString") String myString) {

        DirectorFacade directorFacade = new DirectorFacade();
        ProgressBarListenerInterface progressBar = new ProgressBarListener();

        PlanetarySystem planetarySystem = directorFacade.createSystem(myString);

        int i = 0;
        Future<Integer> currentTask = directorFacade.LoaderwithProgress(progressBar, planetarySystem, this, planetManager);
        while (!currentTask.isDone()) {
            System.out.println("MainCountOfI: " + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return 83;
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
//        System.out.println(Arrays.toString(getStrings(planetManager.getAllPlanets())));
        return getStrings(planetManager.getAllPlanets());
    }

    //TODO 89052023925
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
}