package cn.answering.controller;

import cn.answering.domain.User;
import cn.answering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView admin(Model modele){
    	//find the list of all users given by the user service
        List<User> users = userService.findAllUsers();
        //Add attribute to all users
        modele.addAttribute("users",users);
        //Add the userModel to the routing and return that model and view
        return new ModelAndView("/admin/user/","userModel",modele);
    }
}
