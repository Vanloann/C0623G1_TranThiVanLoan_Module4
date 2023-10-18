package com.example.spring_user_model.controller;

import com.example.spring_user_model.model.Login;
import com.example.spring_user_model.model.User;
import com.example.spring_user_model.service.IUserService;
import com.example.spring_user_model.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ModelAndView showLoginForm () {
        return new ModelAndView("index", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute ("login") Login login) {
        User user = userService.checkLogin(login);
        if (user == null) {
            return new ModelAndView("error");

        } else {
            return new ModelAndView("user", "user", user);

        }
    }
}
