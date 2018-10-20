package springpackage.controller;

import DataBase.DBHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springpackage.spirngclasses.Login;

import java.sql.SQLException;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute Login login, Model model) {
        model.addAttribute("login", login);
        boolean check = true;
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            check = dbHandler.findUser(login.getEmail(), login.getPassword());
            System.out.println(check);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(login.getEmail());
        System.out.println(check);
        if (check)
            return "login";
        else return "nologin";
    }

}
