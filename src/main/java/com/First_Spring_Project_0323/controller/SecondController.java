package com.First_Spring_Project_0323.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    @GetMapping
    public void firstFunc(){
        System.out.println("Second controller got a get request");
    }

}
