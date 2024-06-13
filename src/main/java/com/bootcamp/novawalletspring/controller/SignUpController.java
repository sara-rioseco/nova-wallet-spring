package com.bootcamp.novawalletspring.controller;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.service.*;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * The type Sign up controller.
 */
@Controller
@CommonsLog
@RequestMapping("/signup")
public class SignUpController {

    private final UserService userService;
    private final AccountService accountService;
    private final CurrencyService currencyService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new Sign-up controller.
     *
     * @param userService        the user service
     * @param accountService     the account service
     * @param currencyService    the currency service
     * @param transactionService the transaction service
     * @param contactService     the contact service
     * @param passwordEncoder    the password encoder
     */
    public SignUpController(UserService userService, AccountService accountService, CurrencyService currencyService, TransactionService transactionService, ContactService contactService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.accountService = accountService;
        this.currencyService = currencyService;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Show sign-up view.
     *
     * @param model the model
     * @param error the error
     * @return the string
     */
    @GetMapping
    public String showSignUpView(Model model, @RequestParam(name="error", required=false) String error) {
        if (error != null) {
            model.addAttribute("error", "There's been an error creating your account." );
        }
        return "signup.jsp";
    }

    /**
     * Sign up.
     *
     * @param user  the user
     * @param model the model
     * @return the string
     */
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
            accountService.createAccount(newAcc);
        }
        else {
            model.addAttribute("error", "Error creating new account");
        }
        return "redirect:/login";
    }
}
