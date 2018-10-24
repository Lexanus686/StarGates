package springpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {
    @GetMapping("/mainpage")
    public String mainpageForm(@RequestParam(name = "name", required = false, defaultValue = "World") String mainpage, Model model) {
        model.addAttribute("mainpage", mainpage);
        return "mainpage";
    }
}
