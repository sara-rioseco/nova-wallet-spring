package com.bootcamp.novawalletspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/deposit")
public class DepositController {

    @GetMapping
    public String showDepositView(Model model, @RequestParam(name="error", required=false) String error) {
        if (error != null) {
            model.addAttribute("error", "There's been in the deposit feature." );
        }
        return "deposit.jsp";
    }

}
