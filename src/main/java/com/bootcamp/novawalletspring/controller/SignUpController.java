package com.bootcamp.novawalletspring.controller;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.Role;
import com.bootcamp.novawalletspring.service.AccountService;
import com.bootcamp.novawalletspring.service.CurrencyService;
import com.bootcamp.novawalletspring.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;

@Controller
@CommonsLog
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @GetMapping
    public String showSignUp(Model model, @RequestParam(name="error", required=false) String error) {
        return "signup.jsp";
    }

    @PostMapping
    public String signUp(@ModelAttribute("user") User user, Model model) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("password:" +user.getPassword());
        user.setPassword(encodedPassword);
        User newUser = userService.createUser(user);
        if (newUser != null) {
            Account newAcc = new Account();
            Currency cur = currencyService.getCurrencyById(1);
            newAcc.setCurrency(cur);
            newAcc.setOwner(newUser);
        }
        return "redirect:/login";
    }
}
