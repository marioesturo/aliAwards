package com.aliAwards.service;

import com.aliAwards.model.User;
import com.aliAwards.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User authenticateUser(String accessCode) {
        User user = userRepository.findByAccessCode(accessCode);
        if (user != null) {
            if (user.getFirstLogin() == null) {
                user.setFirstLogin(LocalDateTime.now());
            }
            user.setLastLogin(LocalDateTime.now());
            return userRepository.save(user);
        }
        return null;
    }
}
