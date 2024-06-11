package com.bootcamp.novawalletspring.controller;

import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CommonsLog
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String login(Model model, @RequestParam(name="error", required=false) String error) {
        return "login.jsp";
    }

    @PostMapping
    public ModelAndView login(@RequestParam(name="username") String username) {
        User currentUser = userService.getUserByUsername(username);
        ModelAndView mav = new ModelAndView("home.jsp");
        mav.addObject("username", username);
        mav.addObject("user", currentUser);
        return mav;
    }
}

