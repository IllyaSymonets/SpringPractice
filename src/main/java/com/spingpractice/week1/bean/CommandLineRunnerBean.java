package com.spingpractice.week1.bean;

import java.sql.Date;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spingpractice.week1.dto.UserDto;
import com.spingpractice.week1.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Component
@Slf4j
public class CommandLineRunnerBean implements CommandLineRunner {

    private final UserService userService;

    public void run(String... args) {
        var dtos = Arrays.asList(new UserDto("username1", "male", Date.valueOf("2000-10-10"), "bio1"),
            new UserDto("username2", "female", Date.valueOf("2001-10-10"), "bio2"),
            new UserDto("username3", "unknown", Date.valueOf("2002-10-10"), "bio3"));
        var userIds = dtos.stream().map(userService::saveUser).map(UUID::toString).collect(Collectors.joining(", "));
        log.info("Users with ids:{} created", userIds);
    }
}
