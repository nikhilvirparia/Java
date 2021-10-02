package com.nikhil.daikichi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/daikichi/travel/{city}")
    public String showCity(@PathVariable("city") String city){
        return "Congratulations! You will soon travel to "+ city +"!" ;
    }

    @RequestMapping("/daikichi/lotto/{number}")
    public String showNumber(@PathVariable("number") int number){
        if (number %2 == 1) {
            return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        } else {
            return "You will take a grand journey in the near future, but be weary of tempting offers";
        }
    }


}
