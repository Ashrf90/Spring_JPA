package com.example.demo.user.controllers;


import com.example.demo.user.entities.User;
import com.example.demo.user.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    //----------- Dependency injection of ProductService using constructor injection ---------//
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    //-------------------------------- Post method -----------------------------------//

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    //-------------------------------- Get method -----------------------------------//
    @GetMapping("/Users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/userById/{Id}")
    public User findUserById(@PathVariable int Id){
        return service.getUserById(Id);
    }

    @GetMapping("/user/{name}")
    public User findUserByName(@PathVariable String name){
        return service.getUserByName(name);
    }

    //-------------------------------- Put method -----------------------------------//

    @PutMapping("/updateUser")
    public  User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    //-------------------------------- Delete method -----------------------------------//

    @DeleteMapping("/deleteUser/{Id}")
    public  String deleteUser(@PathVariable int Id){
        return service.deleteUser(Id);
    }




}
