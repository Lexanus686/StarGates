package UI.controller;

import businesslogic.User;
import businesslogic.UserManagerAbstract;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserRegister {

    private UserManagerAbstract userManager;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("registration", new User());
        userManager = new UserManagerAbstract();

        return "forLoginAndRegistration/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("registration", user);

        if (userManager.getUser(user)) {
            userManager.addUser(user);
            return "forLoginAndRegistration/successfullregister";
        } else {
            return "forLoginAndRegistration/failureinregistering";
        }
    }
}