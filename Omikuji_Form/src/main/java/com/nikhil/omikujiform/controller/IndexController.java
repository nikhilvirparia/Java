package com.nikhil.omikujiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping("/omikuji")
    public String index(HttpSession session, Model model) {

        return "index.jsp";
    }

    @RequestMapping("/show")
    public String show(HttpSession session, Model model) {
        model.addAttribute("number", session.getAttribute("number"));
        model.addAttribute("cname", session.getAttribute("cname"));
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("hobby", session.getAttribute("hobby"));
        model.addAttribute("living", session.getAttribute("living"));
        model.addAttribute("description", session.getAttribute("description"));

        return "show.jsp";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(value = "number") int number,
                         @RequestParam(value = "cname")  String cname,
                         @RequestParam(value = "name")   String name,
                         @RequestParam(value = "hobby") String hobby,
                         @RequestParam(value = "living") String living,
                         @RequestParam(value = "description") String description,
                         HttpSession session) {

        session.setAttribute("number", number);
        session.setAttribute("cname", cname);
        session.setAttribute("name", name);
        session.setAttribute("hobby", hobby);
        session.setAttribute("living", living);
        session.setAttribute("description", description);

        return "redirect:/show";

    }



}
