package springpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainForm(@RequestParam(name = "name", required = false, defaultValue = "World") String main, Model model) {
        model.addAttribute("main", main);
        return "main";
    }

}