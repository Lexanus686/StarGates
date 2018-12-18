package UI.controller;

import businesslogic.SignInManager;
import businesslogic.SignInManagerInterface;
import businesslogic.entities.SignIn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInController {

    private SignInManagerInterface signInManager;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String SignInForm(Model model) {
        signInManager = new SignInManager();

        model.addAttribute("signIn", new SignIn());
        return "forLoginAndRegistration/signIn";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String SignInSubmit(@ModelAttribute SignIn signIn, Model model) {
        model.addAttribute("signIn", signIn);

        if (!signInManager.getSignIn(signIn)) {
            return "forLoginAndRegistration/successlogin";
        }
        else return "forLoginAndRegistration/nologin";
    }

}