package com.bootcamp.novawalletspring.controller;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Transaction;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.model.TransactionItem;
import com.bootcamp.novawalletspring.model.TransactionType;
import com.bootcamp.novawalletspring.service.AccountService;
import com.bootcamp.novawalletspring.service.TransactionService;
import com.bootcamp.novawalletspring.service.UserService;
import com.bootcamp.novawalletspring.service.impl.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpSession;
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

/**
 * The type Withdraw controller.
 */
@Controller
@RequestMapping("/withdraw")
public class WithdrawController {

    private final AccountService accountService;
    private final UserService userService;
    private final TransactionService transactionService;
    private final HttpSession httpSession;
    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Instantiates a new Withdrawal controller.
     *
     * @param accountService     the account service
     * @param userService        the user service
     * @param transactionService the transaction service
     * @param httpSession        the http session
     * @param userDetailsService the user details service
     */
    public WithdrawController(AccountService accountService, UserService userService, TransactionService transactionService, HttpSession httpSession, UserDetailsServiceImpl userDetailsService) {
        this.accountService = accountService;
        this.userService = userService;
        this.transactionService = transactionService;
        this.httpSession = httpSession;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Show withdraw view.
     *
     * @param model the model
     * @param error the error
     * @return the string
     */
    @GetMapping
    public String showWithdrawView(Model model, @RequestParam(name="error", required=false) String error) {
        if (error != null) {
            model.addAttribute("error", "There's been in the withdrawal feature." );
        }
        return "withdraw.jsp";
    }

    /**
     * Withdraw.
     *
     * @param model  the model
     * @param amount the amount
     * @return the string
     */
    @PostMapping
    public String withdraw(Model model, @RequestParam(name="amount") BigDecimal amount) {
        User currentUser = userDetailsService.getCurrentUser(userService);
        if (currentUser != null) {
            Account acc = accountService.getAccountByOwnerId(currentUser.getId());
            if (acc != null && amount != null && amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(acc.getBalance()) <= 0) {
                Transaction newTransaction = new Transaction();
                newTransaction.setAmount(amount);
                newTransaction.setCurrency(acc.getCurrency());
                newTransaction.setTransactionType(TransactionType.WITHDRAWAL);
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
                assert acc != null;
                throw new RuntimeException("Account not found with id: " + acc.getId());
            }
        }
        return "withdraw.jsp";
    }
}
