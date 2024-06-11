package com.bootcamp.novawalletspring.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CommonsLog
@RequestMapping("/signup")
public class SignUpController {

    @GetMapping
    public String login(Model model, @RequestParam(name="error", required=false) String error) {
        return "signup.jsp";
    }
}
