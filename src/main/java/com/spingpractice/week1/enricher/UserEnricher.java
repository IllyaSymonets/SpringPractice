package com.spingpractice.week1.enricher;

import java.util.Objects;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.spingpractice.week1.dto.UserDto;
import com.spingpractice.week1.entity.User;
import com.spingpractice.week1.enums.Sex;
import com.spingpractice.week1.exception.ArgumentNotValidException;

import lombok.AllArgsConstructor;

import static com.spingpractice.week1.constant.Constants.USERNAME_MAX_LENGTH;
import static com.spingpractice.week1.constant.Constants.USERNAME_MIN_LENGTH;

@Component
@AllArgsConstructor
public class UserEnricher {

    public void enrich(User user, UserDto dto) {
        if (Objects.isNull(dto)) {
            return;
        }

        if (Objects.nonNull(dto.getBio())) {
            user.setBio(dto.getBio());
        }
        if (Objects.nonNull(dto.getBirthday())) {
            user.setBirthday(dto.getBirthday());
        }
        if (Objects.nonNull(dto.getSex())) {
            user.setSex(Sex.valueOf(dto.getSex().toUpperCase()));
        }
        if (Objects.nonNull(dto.getUsername())) {
            if (IntStream.range(USERNAME_MIN_LENGTH, USERNAME_MAX_LENGTH)
                .noneMatch(integer -> integer == dto.getUsername().length())) {
                throw new ArgumentNotValidException(
                    "Invalid username length it should be in range " + USERNAME_MIN_LENGTH + "-" + USERNAME_MAX_LENGTH + " characters");
            }
            user.setUsername(dto.getUsername());
        }
    }
}
