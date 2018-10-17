package springpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(@RequestParam(name = "login", required = false, defaultValue = "World") String login, Model model) {
        model.addAttribute("login", login);
        return "login";
    }
}
