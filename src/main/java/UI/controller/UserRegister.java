package UI.controller;

import UI.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class UserRegister {

    private final UserManagerAbsrtact _userManager;

    public UserRegister(UserManagerAbsrtact userManager) {
        _userManager = userManager;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("registration", new User());

        return "forLoginAndRegistration/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("registration", user);

        boolean check;

        try {
            check = user.connector();
            if (!check) {
                user.establishUser();
                return "forLoginAndRegistration/successfullregister";
            } else {
                return "forLoginAndRegistration/failureinregistering";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "/error";
        }
    }
}
