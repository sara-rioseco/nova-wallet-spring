package com.bootcamp.novawalletspring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Transactions controller.
 */
@Controller
@RequestMapping("/transactions")
public class TransactionsController {

    private final HttpSession httpSession;

    /**
     * Instantiates a new Transactions controller.
     *
     * @param httpSession the http session
     */
    public TransactionsController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

     /**
     * Show transactions view.
     *
     * @return the transactions
     */
    @GetMapping
    public ModelAndView showTransactionsView() {
        ModelAndView mav = new ModelAndView("transactions.jsp");
        mav.addObject("account", httpSession.getAttribute("account"));
        mav.addObject("currency", httpSession.getAttribute("currency"));
        mav.addObject("balance", httpSession.getAttribute("balance"));
        mav.addObject("user", httpSession.getAttribute("user"));
        mav.addObject("transactions", httpSession.getAttribute("transactions"));
        return mav;
    }
}
