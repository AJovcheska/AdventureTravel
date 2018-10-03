package com.finki.AdventureTravel.controller;

import com.finki.AdventureTravel.adapter.UserService;
import com.finki.AdventureTravel.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity registerUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Override
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @Override
    public ResponseEntity<Boolean> checkIfUserExists(@RequestParam(name = "email") String email,
                                                     @RequestParam(name = "password") String password) {
        User user = userService.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }
}
