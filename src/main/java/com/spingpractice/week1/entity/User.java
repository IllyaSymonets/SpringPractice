package com.spingpractice.week1.entity;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.spingpractice.week1.enums.Sex;

import lombok.Data;

import static com.spingpractice.week1.constant.UserValidationConstants.USERNAME_MAX_LENGTH;
import static com.spingpractice.week1.constant.UserValidationConstants.USERNAME_MIN_LENGTH;

@Data
@Entity
@Table
public class User {

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Id
    @Column
    private UUID id;

    @Column(unique = true, nullable = false, length = USERNAME_MAX_LENGTH)
    @Size(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(length = 7)

    private Sex sex = Sex.UNKNOWN;

    @Column(nullable = false)
    @NotNull
    @Past
    private Date birthday;

    @Column
    private String bio;
}
