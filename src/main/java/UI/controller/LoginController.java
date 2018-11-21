package UI.controller;

import businesslogic.Login;
import businesslogic.LoginManagerAbstract;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private LoginManagerAbstract loginManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        loginManager = new LoginManagerAbstract();

        model.addAttribute("login", new Login());
        return "forLoginAndRegistration/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute Login login, Model model) {
        model.addAttribute("login", login);

        if (!loginManager.getLogin(login)) {
            return "forLoginAndRegistration/successlogin";
        }
        else return "forLoginAndRegistration/nologin";
    }

}