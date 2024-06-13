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
import com.bootcamp.novawalletspring.service.impl.UserDetailsServiceImpl;
import com.bootcamp.novawalletspring.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.bootcamp.novawalletspring.utils.Utils.*;

/**
 * The type Home controller.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private final AccountService accountService;
    private final UserService userService;
    private final TransactionService transactionService;
    private final ContactService contactService;
    private final HttpSession httpSession;
    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Instantiates a new Home controller.
     *
     * @param accountService     the account service
     * @param userService        the user service
     * @param transactionService the transaction service
     * @param contactService     the contact service
     * @param httpSession        the http session
     * @param userDetailsService the user details service
     */
    public HomeController(AccountServiceImpl accountService, UserServiceImpl userService, TransactionServiceImpl transactionService, ContactService contactService, HttpSession httpSession, UserDetailsServiceImpl userDetailsService) {
        this.accountService = accountService;
        this.userService = userService;
        this.transactionService = transactionService;
        this.contactService = contactService;
        this.httpSession = httpSession;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Show home model and view.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping
    public ModelAndView showHomeView(Model model) {
        User currentUser = userDetailsService.getCurrentUser(userService);
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
}