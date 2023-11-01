package com.First_Spring_Project_0323.controller;

import com.First_Spring_Project_0323.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/second")
public class SecondController {

    HashMap<Integer,User> users = new HashMap<>();

    @PostMapping
    public String createUser(@RequestBody User user){
        if(users.containsKey(user.getUserId())){
            return "user already exists";
        }else{
            users.put(user.getUserId(),user);
            return "user was created";
        }
    }

    @DeleteMapping
    public String deleteUserById(@RequestParam int id){
        if(users.containsKey(id)){
            users.remove(id);
            return "user was deleted";
        }else{
            return "user not found";
        }
    }

    @PutMapping(value = "/update_name")
    public String updateUserName(@RequestParam String name, @RequestParam int id){
        if(users.containsKey(id) && name != null && name.length() > 0){
            users.get(id).setUserName(name);
            return "user's name was updated";
        }else{
            return "user's not found or name was empty";
        }
    }

    @PutMapping(value = "/update_email")
    public String updateUserEmail(@RequestParam String email, @RequestParam int id){
        if(users.containsKey(id) && email != null && email.length() > 0){
            users.get(id).setUserEmail(email);
            return "user's email was updated";
        }else{
            return "user not found or email was empty";
        }
    }

    @PutMapping(value = "/update_user")
    public String updateUser(@RequestBody User user){
        if(users.containsKey(user.getUserId())){
            User temp = users.get(user.getUserId());
            if(user.getUserName() != null){
                temp.setUserName(user.getUserName());
            }
            if(user.getUserEmail() != null){
                temp.setUserEmail(user.getUserEmail());
            }
            return "user name and/or email was changed";
        }else{
            return "user not found";
        }
    }

    @GetMapping(value = "/all")
    public HashMap<Integer,User> getAllUsers(){
        return users;
    }

    @GetMapping(value = "/by_id")
    public User getUserById(@RequestParam int id){
        return users.get(id);
    }


}
