package com.spingpractice.week1.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.spingpractice.week1.constant.UserValidationConstants.USERNAME_MAX_LENGTH;
import static com.spingpractice.week1.constant.UserValidationConstants.USERNAME_MIN_LENGTH;

@Data
@AllArgsConstructor
public class UserDto {
    @Size(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH)
    private String username;
    private String sex;
    @NotNull
    @Past
    private LocalDate birthday;
    private String bio;
}
