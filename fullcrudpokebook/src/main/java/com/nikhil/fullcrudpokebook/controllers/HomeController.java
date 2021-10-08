package com.nikhil.fullcrudpokebook.controllers;

import com.nikhil.fullcrudpokebook.models.Expense;
import com.nikhil.fullcrudpokebook.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    ExpenseService expenseServ;

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {

        List<Expense> allExpense = expenseServ.allpoke();

        model.addAttribute("expenses", allExpense);

        return "index.jsp";
    }

    @RequestMapping("/expenses/edit")
    public String edit() {
        return "edit.jsp";
    }

    @RequestMapping("/expenses")
    public String expenses() {
        return "expenses.jsp";
    }

}
