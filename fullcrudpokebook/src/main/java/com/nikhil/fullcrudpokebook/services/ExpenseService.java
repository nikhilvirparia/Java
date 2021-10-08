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
    public List<Expense> allpoke() {
        return expenseRepository.findAll();
    }



}
