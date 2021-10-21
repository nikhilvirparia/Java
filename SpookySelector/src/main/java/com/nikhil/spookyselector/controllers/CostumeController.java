package com.nikhil.spookyselector.controllers;

import com.nikhil.spookyselector.services.CostumeService;
import com.nikhil.spookyselector.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class CostumeController {

    // Dependency Injection
    private final CostumeService costumeService;
    private final UserService userService;

    @Autowired
    public CostumeController(CostumeService costumeService, UserService userService) {
        this.costumeService = costumeService;
        this.userService = userService;
    }

    // Costume Chooser for the dashboard
    @RequestMapping(value = "/costume/chooser", method = RequestMethod.POST)
    public String index(HttpSession session) {
        session.setAttribute("costumeName", costumeService.randomCostume());
        return "redirect:/costume/result";
    }

    // Costume picker for the picture
    @RequestMapping("/costume/picture")
    public String pictures(HttpSession session, Model model) {
        model.addAttribute("costumeName", session.getAttribute("costumeName"));
        return "showCostumes.jsp";
    }

    // Show the result of the Costume
    @RequestMapping("/costume/result")
    public String result(HttpSession session, Model model) {
        model.addAttribute("costumeName", session.getAttribute("costumeName"));
        return "costumesResult.jsp";
    }

}
