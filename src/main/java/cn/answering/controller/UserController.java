package cn.answering.controller;

import cn.answering.domain.User;
import cn.answering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/user-controller")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(){
    	//Return a simple string to test
        return "index";
    }

    @PostMapping
    public String addUser(@RequestParam("username")String pseudonom,
                          @RequestParam("name")String nom){
    	// Instansiate a new user
        User utilisateur = new User(pseudonom,nom);
        // Update or enter the new user if they exist
        userService.update(utilisateur);
        // Redirect to admin route
        return "redirect:/admin";
    }
}
