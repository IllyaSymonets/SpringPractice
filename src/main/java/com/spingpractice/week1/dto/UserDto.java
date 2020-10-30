package com.spingpractice.week1.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.spingpractice.week1.constant.Constants.USERNAME_MAX_LENGTH;
import static com.spingpractice.week1.constant.Constants.USERNAME_MIN_LENGTH;

@Data
@AllArgsConstructor
public class UserDto {
    @Size(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH)
    private String username;
    private String sex;
    @NotNull
    private Date birthday;
    private String bio;
}
