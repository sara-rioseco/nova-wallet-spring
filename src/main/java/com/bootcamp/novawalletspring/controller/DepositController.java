package com.bootcamp.novawalletspring.controller;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.TransactionItem;
import com.bootcamp.novawalletspring.model.TransactionType;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

import static com.bootcamp.novawalletspring.utils.Utils.formatBigDecimalAsCurrency;
import static com.bootcamp.novawalletspring.utils.Utils.formatTransactions;

@Controller
@RequestMapping("/deposit")
public class DepositController {

    private final AccountService accountService;
    private final UserService userService;
    private final TransactionService transactionService;
    private final HttpSession httpSession;


    public DepositController(AccountServiceImpl accountService, UserServiceImpl userService, TransactionServiceImpl transactionService, ContactService contactService, HttpSession httpSession) {
        this.accountService = accountService;
        this.userService = userService;
        this.transactionService = transactionService;
        this.httpSession = httpSession;
    }

    @GetMapping
    public String showDepositView(Model model, @RequestParam(name="error", required=false) String error) {
        if (error != null) {
            model.addAttribute("error", "There's been in the deposit feature." );
        }
        return "deposit.jsp";
    }

    @PostMapping
    public String deposit(Model model, @RequestParam(name="amount") BigDecimal amount) {
        User currentUser = getCurrentUser(userService);
        if (currentUser != null) {
            Account acc = accountService.getAccountByOwnerId(currentUser.getId());
            if (acc != null && amount != null && amount.compareTo(BigDecimal.ZERO) > 0) {
                Transaction newTransaction = new Transaction();
                newTransaction.setAmount(amount);
                newTransaction.setCurrency(acc.getCurrency());
                newTransaction.setTransactionType(TransactionType.DEPOSIT);
                newTransaction.setSenderUser(acc.getOwner());
                newTransaction.setReceiverUser(acc.getOwner());
                newTransaction.setSenderAccount(acc);
                newTransaction.setReceiverAccount(acc);
                Account updatedAcc = accountService.updateBalance(newTransaction, accountService.getAccountById(acc.getId()));
                List<TransactionItem> newTransactions = formatTransactions(transactionService.getTransactionsByUserId(updatedAcc.getOwner().getId()), currentUser);
                httpSession.setAttribute("acc", updatedAcc);
                httpSession.setAttribute("transactions", newTransactions);
                httpSession.setAttribute("balance", formatBigDecimalAsCurrency(updatedAcc.getBalance(), updatedAcc.getCurrency()));
            } else {
                throw new RuntimeException("Account not found with id: " + acc.getId());
            }
        }
        return "deposit.jsp";
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
