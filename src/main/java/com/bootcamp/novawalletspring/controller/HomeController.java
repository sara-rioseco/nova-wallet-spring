package com.bootcamp.novawalletspring.controller;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.TransactionItem;
import com.bootcamp.novawalletspring.service.AccountService;
import com.bootcamp.novawalletspring.service.ContactService;
import com.bootcamp.novawalletspring.service.TransactionService;
import com.bootcamp.novawalletspring.service.UserService;
import com.bootcamp.novawalletspring.service.impl.AccountServiceImpl;
import com.bootcamp.novawalletspring.service.impl.TransactionServiceImpl;
import com.bootcamp.novawalletspring.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.bootcamp.novawalletspring.utils.Utils.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final AccountService accountService;
    private final UserService userService;
    private final TransactionService transactionService;
    private final ContactService contactService;
    private final HttpSession httpSession;


    public HomeController(AccountServiceImpl accountService, UserServiceImpl userService, TransactionServiceImpl transactionService, ContactService contactService, HttpSession httpSession) {
        this.accountService = accountService;
        this.userService = userService;
        this.transactionService = transactionService;
        this.contactService = contactService;
        this.httpSession = httpSession;
    }

    @GetMapping
    public ModelAndView home(Model model) {
        User currentUser = getCurrentUser(userService);
        ModelAndView mav;
        if (currentUser != null) {
            Account acc = accountService.getAccountByOwnerId(currentUser.getId());
            String balance = formatBigDecimalAsCurrency(acc.getBalance(), acc.getCurrency());
            Iterable<Transaction> transactions = transactionService.getTransactionsByUserId(currentUser.getId());
            List<TransactionItem> formattedTr = formatTransactions(transactions, currentUser);
            mav = new ModelAndView("home.jsp");
            httpSession.setAttribute("user", currentUser);
            httpSession.setAttribute("account", acc);
            httpSession.setAttribute("currency", acc.getCurrency().getSymbol());
            httpSession.setAttribute("balance", balance);
            httpSession.setAttribute("balanceBD", acc.getBalance());
            httpSession.setAttribute("contacts", contactService.getAllContactsByOwnerId(currentUser.getId()));
            httpSession.setAttribute("transactions", formattedTr);
        } else {
            mav = new ModelAndView("login.jsp");
        }
        return mav;
    }



    public User getCurrentUser(UserService userService) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return userService.getUserByUsername(username);
        }
        return null;
    }

}