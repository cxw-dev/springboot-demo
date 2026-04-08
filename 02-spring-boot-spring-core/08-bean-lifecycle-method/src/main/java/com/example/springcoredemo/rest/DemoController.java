package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach coach) {
        myCoach = coach;
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans: myCoach == antherCoach, " + (myCoach == anotherCoach);
//    }
}
