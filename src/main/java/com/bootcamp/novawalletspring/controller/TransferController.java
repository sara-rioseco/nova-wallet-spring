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
 * The type Transfer controller.
 */
@Controller
@RequestMapping("/transfer")
public class TransferController {

    private final AccountService accountService;
    private final UserService userService;
    private final TransactionService transactionService;
    private final ContactService contactService;
    private final UserDetailsServiceImpl userDetailsService;
    private final HttpSession httpSession;


    /**
     * Instantiates a new Transfer controller.
     *
     * @param accountService     the account service
     * @param userService        the user service
     * @param transactionService the transaction service
     * @param contactService     the contact service
     * @param httpSession        the http session
     * @param userDetailsService the user details service
     */
    public TransferController(AccountService accountService, UserService userService, TransactionService transactionService, ContactService contactService, HttpSession httpSession, UserDetailsServiceImpl userDetailsService) {
        this.accountService = accountService;
        this.userService = userService;
        this.transactionService = transactionService;
        this.contactService = contactService;
        this.httpSession = httpSession;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Show transfer view.
     *
     * @param model the model
     * @param error the error
     * @return the string
     */
    @GetMapping
    public String showTransferView(Model model, @RequestParam(name="error", required=false) String error) {
        if (error != null) {
            model.addAttribute("error", "There's been in the transfer feature." );
        }
        return "transfer.jsp";
    }

    /**
     * Transfer.
     *
     * @param model      the model
     * @param amount     the amount
     * @param receiverId the receiver id
     * @return the string
     */
    @PostMapping
    public String transfer(Model model, @RequestParam(name="amount") BigDecimal amount, @RequestParam(name="contact") int receiverId) {
        User currentUser = userDetailsService.getCurrentUser(userService);
        if (currentUser != null) {
            Account senderAcc = accountService.getAccountByOwnerId(currentUser.getId());
            Account receiverAcc = accountService.getAccountByOwnerId(contactService.getContactUserByContactId(receiverId).getId());
            if (senderAcc != null && receiverAcc != null && amount != null && amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(senderAcc.getBalance()) <= 0) {
                Transaction newTransaction = new Transaction();
                newTransaction.setAmount(amount);
                newTransaction.setCurrency(senderAcc.getCurrency());
                newTransaction.setTransactionType(TransactionType.TRANSFER);
                newTransaction.setSenderUser(senderAcc.getOwner());
                newTransaction.setReceiverUser(receiverAcc.getOwner());
                newTransaction.setSenderAccount(senderAcc);
                newTransaction.setReceiverAccount(receiverAcc);
                Account updatedSenderAcc = accountService.updateBalance(newTransaction, accountService.getAccountById(senderAcc.getId()));
                accountService.updateBalance(newTransaction, accountService.getAccountById(receiverAcc.getId()));
                List<TransactionItem> newTransactions = formatTransactions(transactionService.getTransactionsByUserId(updatedSenderAcc.getOwner().getId()), currentUser);

                httpSession.setAttribute("acc", updatedSenderAcc);
                httpSession.setAttribute("transactions", newTransactions);
                httpSession.setAttribute("balance", formatBigDecimalAsCurrency(updatedSenderAcc.getBalance(), updatedSenderAcc.getCurrency()));
            } else {
                assert senderAcc != null;
                throw new RuntimeException("Account not found with id: " + senderAcc.getId());
            }
        }
        return "home.jsp";
    }

}
