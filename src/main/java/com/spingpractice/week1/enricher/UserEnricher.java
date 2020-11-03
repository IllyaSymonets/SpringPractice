package com.spingpractice.week1.enricher;

import java.sql.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spingpractice.week1.dto.UserDto;
import com.spingpractice.week1.entity.User;
import com.spingpractice.week1.enums.Sex;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserEnricher {

    public void enrich(User user, UserDto dto) {
        if (Objects.isNull(dto)) {
            return;
        }

        user.setBio(dto.getBio());

        if (Objects.nonNull(dto.getBirthday())) {
            user.setBirthday(Date.valueOf(dto.getBirthday()));
        }
        if (Objects.nonNull(dto.getSex())) {
            user.setSex(Sex.valueOf(dto.getSex().toUpperCase()));
        }
        if (Objects.nonNull(dto.getUsername())) {
            user.setUsername(dto.getUsername());
        }
    }
}
