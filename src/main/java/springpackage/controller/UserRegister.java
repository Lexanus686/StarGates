package springpackage.controller;

import DataBase.DBHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springpackage.spirngclasses.User;

import java.sql.SQLException;

@Controller
public class UserRegister {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("registration", new User());
        System.out.println("HERE");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("registration", user);
        boolean check = true;
        System.out.println("SOMETHING?" + user.getEmail() + user.getPassword());
        try {
            System.out.println(user.getEmail() + user.getPassword());
            DBHandler dbHandler = DBHandler.getInstance();
            System.out.println("LOGIN:" + user.getEmail());
            check = dbHandler.findUser(user.getEmail(), user.getPassword());
            System.out.println(check);
            if (!check) {
                dbHandler.addUser(user);
                return "successfullregister";
            } else {
                System.out.println("ERROR");
                return "failureinregistering";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user.getEmail() + " " + user.getPassword());
        System.out.println(check);
        return "finalpage";

//        if (check)
//            return "login";
//        else return "nologin";
    }
}
