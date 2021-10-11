package com.nikhil.fullcrudpokebook.controllers;

import com.nikhil.fullcrudpokebook.models.Expense;
import com.nikhil.fullcrudpokebook.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ExpenseService expenseServ;

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {

        List<Expense> allExpense = expenseServ.allExpense();

        model.addAttribute("expenses", allExpense);

        return "index.jsp";
    }

    // This is the action from the form to actually make the expense
    @RequestMapping(value="/creatExpense", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "/index.jsp";
        } else {
            expenseServ.createExpense(expense);
            return "redirect:/";
        }
    }

        @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
        public String destroy(@PathVariable("id") Long id) {
            expenseServ.deleteExpense(id);
            return "redirect:/";
        }


    // Render the JSP for the for to edit the expenses
    @RequestMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense editExpense = expenseServ.getOneExpense(id);
        model.addAttribute("editExpense", editExpense);

        return "edit.jsp";
    }

    // Redirect Pokebook
    @RequestMapping(value="/editExpense/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("editExpense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            expenseServ.updateOneExpense(expense);
            return "redirect:/";
        }
    }

    // Show the expenses
    @RequestMapping("/expenses/{id}")
    public String expenses(@PathVariable("id") Long id, Model model) {

        Expense expenseDetails = expenseServ.getOneExpense(id);
        model.addAttribute("expense", expenseDetails);

        return "expenses.jsp";
    }

}
