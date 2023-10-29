package com.First_Spring_Project_0323.controller;

import com.First_Spring_Project_0323.model.User;
import org.springframework.web.bind.annotation.*;

// localhost:8081/first
@RestController
@RequestMapping("/first")
public class FirstController {

    //Create Read Update Delete
    //Post   Get  Put    Delete - API requests

    // request GET -> localhost:8081/first/func1
    @GetMapping(value = "/func1")
    public void firstFunc(){
        System.out.println("First controller got a get request for the first function");
    }

    // request GET ->  localhost:8081/first/func2
    @GetMapping(value = "/func2")
    public void secondFunc(){
        System.out.println("First controller got a get request for the second function");
    }

    @GetMapping(value = "/string")
    public String thirdFunc(){
        return "This is a string from the first controller third function";
    }

    // PathVariable
    @GetMapping(value = "/number/{number}")
    public int fourthFunc(@PathVariable int number){
        return number + 5;
    }

    //RequestParam
    @GetMapping(value = "/number")
    public int fifthFunc(@RequestParam int x){
        return x + 3;
    }

//    @PostMapping
//    public String createUser(@RequestBody User user){
//        return "User " + user.getName() + " was created";
//    }

    @PostMapping
    public User createUser(@RequestBody User user){
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        return user;
    }

}
