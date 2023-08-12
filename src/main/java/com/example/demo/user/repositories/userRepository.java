package com.example.demo.user.repositories;

import com.example.demo.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}

