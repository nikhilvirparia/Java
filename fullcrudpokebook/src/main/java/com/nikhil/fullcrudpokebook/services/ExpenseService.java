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

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);

    }

    // Method to find all the Pokebook
    public List<Expense> allpoke() {
        return expenseRepository.findAll();
    }

}
