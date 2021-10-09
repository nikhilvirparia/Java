package com.nikhil.fullcrudpokebook.controllers;

import com.nikhil.fullcrudpokebook.models.Expense;
import com.nikhil.fullcrudpokebook.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @RequestMapping(value="/pokes", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        System.out.println(expense.getAmount() + "    " + expense.getVendor());
        if (result.hasErrors()) {
            return "/index.jsp";
        } else {
            expenseServ.createExpense(expense);
            return "redirect:/";
        }
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
