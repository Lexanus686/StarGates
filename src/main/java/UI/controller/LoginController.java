package UI.controller;

import UI.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());
        return "forLoginAndRegistration/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute Login login, Model model) {
        model.addAttribute("login", login);

        boolean check = true;

        try {
            check = login.checkLogin();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (check)
            return "forLoginAndRegistration/successfullregister";
        else return "forLoginAndRegistration/nologin";
    }

}
