package com.bootcamp.novawalletspring.controller;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {

    private final HttpSession httpSession;

    public TransactionsController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping
    public ModelAndView getTransactions() {
        ModelAndView mav = new ModelAndView("transactions.jsp");
        mav.addObject("account", httpSession.getAttribute("account"));
        mav.addObject("currency", httpSession.getAttribute("currency"));
        mav.addObject("balance", httpSession.getAttribute("balance"));
        mav.addObject("user", httpSession.getAttribute("user"));
        mav.addObject("transactions", httpSession.getAttribute("transactions"));
        return mav;
    }
}
