package com.nikhil.daikichi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiControllers {

    @RequestMapping("/daikichi")
    public String index(){
        return "Welcome!";
    }

    // Daikichi/today
    @RequestMapping(value="/daikichi/today")
    public String today(){
        return "Today you will find luck in all your endeavors!";
    }

    // Daikichi/tomorrow
    @RequestMapping(value="/daikichi/tomorrow")
    public String tomorrow(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!  ";
    }


}
