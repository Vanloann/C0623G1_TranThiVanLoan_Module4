package com.example.validateloginform.controller;

import com.example.validateloginform.model.User;
import com.example.validateloginform.model.UserDTO;
import com.example.validateloginform.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private IUserService userService;

   @GetMapping
   public ModelAndView showForm() {
       return new ModelAndView("signup", "userDTO", new UserDTO());
   }

   @PostMapping("/create")
    public String SaveUser(@Validated @ModelAttribute UserDTO userDTO,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "signup";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            userService.saveUser(user);
            return "redirect:/";
        }
   }
}
