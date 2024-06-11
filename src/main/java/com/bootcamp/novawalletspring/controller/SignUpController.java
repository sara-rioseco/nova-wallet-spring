package com.bootcamp.novawalletspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    public String login(Model model, @RequestParam(name="error", required=false) String error) {
        return "signup.jsp";
    }
}
