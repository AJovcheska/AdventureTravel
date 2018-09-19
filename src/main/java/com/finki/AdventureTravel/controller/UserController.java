package com.finki.AdventureTravel.controller;

import com.finki.AdventureTravel.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

import java.util.List;

@ResponseBody
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public interface UserController {

    @PostMapping(value = "/users")
    ResponseEntity registerUser(@RequestBody User user);

    @GetMapping(value = "/users")
    ResponseEntity<List<User>> findAll();

    @GetMapping(value = "/users/{email}")
    ResponseEntity<User> findByEmail(@PathVariable String email);
}
