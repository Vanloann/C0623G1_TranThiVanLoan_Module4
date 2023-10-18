package com.example.validateemail.controller;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("")
public class HomeController {
    private static final String EMAIL_REGEX = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
    private static Pattern pattern;

    public HomeController () {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    private boolean validate(String regex) {
        System.out.println(regex);
        Matcher matcher = pattern.matcher(regex);
        System.out.println(matcher.matches());
        return matcher.matches();
    }

    @GetMapping("")
    public String home () {
        return "index";
    }

    @PostMapping("/validate")
    public ModelAndView user (@RequestParam String email) {
        System.out.println(this.validate(email));
        boolean isvalid = this.validate(email);
        System.out.println(isvalid);
        if (!isvalid) {
            return new ModelAndView("index", "message", "Email is invalid!");
        }
        return new ModelAndView("success", "email", email);
    }

}
