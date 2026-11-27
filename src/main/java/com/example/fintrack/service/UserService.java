package com.example.fintrack.service;

import com.example.fintrack.entity.User;
import com.example.fintrack.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public User saveUser(User user) {

        String encodedPassword =
                passwordEncoder.encode(user.getPasswordHash());

        user.setPasswordHash(encodedPassword);

        return userRepository.save(user);
    }
}