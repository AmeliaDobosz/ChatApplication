package app.chataplication.controllers;

import app.chataplication.entities.User;
import app.chataplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String showUsersList(Model model){
        List<User> UserList = userService.listAll();
        model.addAttribute("UserList", UserList);
        return "user";
    }

    @GetMapping("/sing_up")
    public String SingUp(Model model){
        model.addAttribute("new_user", new User());
        return "userRegistry";
    }

    @PostMapping("user/save")
    public String singUpNewUser(User user){
        userService.save(user);
        return "redirect:";
    }

}
