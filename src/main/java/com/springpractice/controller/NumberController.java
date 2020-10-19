package com.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.service.NumberService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/number")
public class NumberController {

    @Autowired
    NumberService numberService;

    @GetMapping("/random")
    public ResponseEntity<Integer> getRandomInteger() {
        return ResponseEntity.ok(numberService.getRandomNumber());
    }

    @PutMapping("/increment")
    public ResponseEntity<Integer> getIncremented() {
        return ResponseEntity.ok(numberService.incrementValue());
    }

    @PutMapping
    public ResponseEntity<Integer> setValue(@RequestBody Integer value) {
        numberService.setValue(value);
        return ResponseEntity.ok(value);
    }
}
