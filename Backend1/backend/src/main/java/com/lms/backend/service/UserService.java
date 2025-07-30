package com.lms.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.backend.model.User;
import com.lms.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public User login(String email, String password) {
        return repo.findByEmail(email)
                   .filter(u -> u.getPassword().equals(password))
                   .orElse(null);
    }
}
