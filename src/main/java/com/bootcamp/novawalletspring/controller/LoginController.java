package com.bootcamp.novawalletspring.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CommonsLog
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, @RequestParam(name="error", required=false) String error) {
        return "login.jsp";
    }

}

