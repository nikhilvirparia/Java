package com.nikhil.fullcrudpokebook.services;

import com.nikhil.fullcrudpokebook.models.Expense;
import com.nikhil.fullcrudpokebook.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    // Method to find all the Pokebook
    public List<Expense> allExpense() {
        return expenseRepository.findAll();
    }

    // Method to createExpense
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Delete
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Get one Expense
    public Expense getOneExpense (Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }

    // Edit the expense
    public Expense updateOneExpense(Expense expense) {
       return expenseRepository.save(expense);
    }
}
