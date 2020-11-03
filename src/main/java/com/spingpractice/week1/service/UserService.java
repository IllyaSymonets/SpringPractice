package com.spingpractice.week1.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.spingpractice.week1.dto.UserDto;
import com.spingpractice.week1.enricher.UserEnricher;
import com.spingpractice.week1.entity.User;
import com.spingpractice.week1.exception.UserNotFoundException;
import com.spingpractice.week1.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserEnricher userEnricher;

    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() ->
            new UserNotFoundException("User with id " + userId + " not found"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
            new UserNotFoundException("User with username " + username + "not found"));
    }

    public UUID saveUser(UserDto dto) {
        var user = new User();
        userEnricher.enrich(user, dto);
        userRepository.save(user);
        return user.getId();
    }

    public UUID updateUser(UUID userId, UserDto dto) {
        var user = userRepository.findById(userId).orElseThrow(() ->
            new UserNotFoundException("User with id " + userId + "not found"));
        userEnricher.enrich(user, dto);
        userRepository.save(user);
        return userId;
    }

    public UUID deleteUser(UUID userId) {
        userRepository.findById(userId).orElseThrow(() ->
            new UserNotFoundException("User with id " + userId + " not found"));
        userRepository.deleteById(userId);
        return userId;
    }
}
