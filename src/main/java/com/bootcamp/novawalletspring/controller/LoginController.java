package com.bootcamp.novawalletspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, @RequestParam(name="error", required=false) String error) {
        return "login.jsp";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam(name="error", required=false) String error, @RequestParam(name="mail", required=true) String mail, @RequestParam(name="pass", required=true) String pass, Model model) {
        System.out.println("mail: " + mail);
        model.addAttribute("error", error);
        return "home.jsp";
    }

}

