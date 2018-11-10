package UI.controller;

import UI.models.PlanetUI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainPageController {

    @RequestMapping(value = "/getPlanet", method = RequestMethod.GET)
    public @ResponseBody
    String getPlanet(@RequestParam String text) {
        PlanetUI planet = new PlanetUI();
        System.out.println("321");

        /*planet.setName(name);
        planet.setAvailableToVisit(isVisited);
        planet.setAverageTemperature(avg);
        planet.setGravitationPower(gravity);
        planet.setStarGate(gateName);*/
        System.out.println(text);
        return text;
    }

    @GetMapping("/mainpage")
    public String mainPageForm(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        model.addAttribute("main", mainpage);
        return "mainpage";
    }

    @PostMapping("/mainpage")
    public String mainPagePost(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        model.addAttribute("main", mainpage);
        return "mainpage";
    }
}
