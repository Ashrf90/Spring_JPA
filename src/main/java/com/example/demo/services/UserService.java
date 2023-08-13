package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //----------- Dependency injection of ProductRepository using constructor injection ---------//

    private final userRepository repository;

    public UserService(userRepository repository) {
        this.repository = repository;
    }

    //-------------------------------- Post method -----------------------------------//
    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    //-------------------------------- Get method -----------------------------------//
    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(int Id){
        return repository.findById(Id).orElse(null);
    }

    public User getUserByName(String name){
        return repository.findByName(name);
    }

    //-------------------------------- Delete method -----------------------------------//
    public String deleteUser(int Id){
        repository.deleteById(Id);
        return "User removed !" + Id;
    }

    //-------------------------------- Update method -----------------------------------//
    public User updateUser(User user){
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAddress(user.getAddress());
        return repository.save(existingUser);
    }

}
