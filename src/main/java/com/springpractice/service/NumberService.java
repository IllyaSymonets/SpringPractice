package com.springpractice.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumberService {

    Random random = new Random();

    private static Integer value = 0;

    public int getRandomNumber() {
        return random.nextInt();
    }

    public int incrementValue() {
        return value++;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
