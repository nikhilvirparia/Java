package com.nikhil.fullcrudpokebook.repositories;

import com.nikhil.fullcrudpokebook.models.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    // This method retrieves all the Pokes from the database
    List<Expense> findAll();

    // This method finds poke with
    List<Expense> findByDescriptionContaining(String search);

//    // this method counts how many titles contain a certain string
//    Long countByNameContaining(String search);
//
//    // this method deletes a Poke that starts with a specific title
//    Long deleteByNameStartingWith(String search);

}
