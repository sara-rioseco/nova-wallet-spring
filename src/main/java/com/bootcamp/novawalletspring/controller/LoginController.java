package com.bootcamp.novawalletspring.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Login controller.
 */
@Controller
@CommonsLog
@RequestMapping("/login")
public class LoginController {

    /**
     * Login.
     *
     * @param error the error
     * @param model the model
     * @return the string
     */
    @GetMapping
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Wrong credentials");
        }
        return "login.jsp";
    }

}

