package com.nikhil.fruity_loops.controllers;

import com.nikhil.fruity_loops.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

// ... imports (Use shift+ctrl+O or shift+cmd+O to import as you code)
@Controller
public class ItemController {

    @RequestMapping("/")
    public String index(Model model) {

        ArrayList<Item> fruits = new ArrayList<>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", .75));

        // Add fruits your view model here
        model.addAttribute("ItemController", fruits);
        return "index";
    }
}


