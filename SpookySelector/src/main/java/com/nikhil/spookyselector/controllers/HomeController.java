package com.nikhil.spookyselector.controllers;

import com.nikhil.spookyselector.models.LoginUser;
import com.nikhil.spookyselector.models.User;
import com.nikhil.spookyselector.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userServ;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    // Register
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/costume/chooser";
    }

    // Login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/costume/chooser";
    }

    // Goes to the dashboard page
    @RequestMapping("/costume/chooser")
    public String dashboard(Model model, HttpSession session) {
        if(session.getAttribute("user_id") !=  null) {
            Long user_id = (Long)session.getAttribute("user_id");
            User user = userServ.getById(user_id);
            model.addAttribute("user", user);

            return"dashboard.jsp";
        }else {
            return "redirect:/";
        }
    }
    
    //End Logout button
    @GetMapping("/logout")
    public  String logout(HttpSession session) {
        session.removeAttribute("user_id");
        return "redirect:/";
    }


}