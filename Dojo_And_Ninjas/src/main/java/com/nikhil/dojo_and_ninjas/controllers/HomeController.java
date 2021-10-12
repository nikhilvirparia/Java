package com.nikhil.dojo_and_ninjas.controllers;

import com.nikhil.dojo_and_ninjas.models.Dojo;
import com.nikhil.dojo_and_ninjas.models.Ninja;
import com.nikhil.dojo_and_ninjas.services.DojoService;
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
    DojoService dojoService;


    // New Dojo
    @RequestMapping("/dojos/new")
    public String index(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo.jsp";
    }

    @RequestMapping(value="/newDojo", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }

    // New Ninja
    @RequestMapping("/ninjas/new")
    public String ninjas(Model model, @ModelAttribute("ninja") Ninja ninja) {
        List<Dojo> newDojo = dojoService.allDojo();
        model.addAttribute("newDojo", newDojo);
        return "newNinja.jsp";
    }

    @RequestMapping(value="/newNinja", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newNinja.jsp";
        } else {
            dojoService.createNinja(ninja);
            return "redirect:/";
        }
    }

    // Show One Dojo
    @RequestMapping("/dojos/{id}")
    public String dojo (@PathVariable("id") Long id, Model model) {

        Dojo dojoDetails = dojoService.getOneDojo(id);
        model.addAttribute("dojo", dojoDetails);

        return "oneDojo.jsp";
    }

    // All Dojo (Information all dojos)
    @RequestMapping("/")
    public String info (Model model) {
        List<Dojo> info = dojoService.allDojo();
        model.addAttribute("info", info);

        return "info.jsp";
    }

}
