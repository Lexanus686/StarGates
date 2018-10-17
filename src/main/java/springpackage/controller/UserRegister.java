package springpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springpackage.spirngclasses.Registration;

@Controller
public class UserRegister {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerSubmit(@ModelAttribute Registration registration, Model model) {
        model.addAttribute("registration", registration);
        return "finalform";
    }
}
