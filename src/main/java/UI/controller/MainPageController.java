package UI.controller;

import UI.models.PlanetUI;
import businesslogic.Planet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
    public String mainpageForm(Model model) {
        model.addAttribute("mainpage", new PlanetUI());
        return "mainpage";
    }

    @RequestMapping(value = "/mainpage", method = RequestMethod.POST)
    public String mainpagePostForm(PlanetUI planetUI, Model model) {
        model.addAttribute("mainpage", planetUI);
        Planet planet = new Planet(planetUI.getName(), true, planetUI.getAverageTemperature(), planetUI.getGravitationPower(), planetUI.getStarGate());
        /*...*/
        return "mainpage";
    }
}
