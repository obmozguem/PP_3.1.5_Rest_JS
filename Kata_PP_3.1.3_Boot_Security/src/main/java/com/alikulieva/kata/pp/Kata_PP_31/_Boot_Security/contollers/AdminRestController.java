package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;


import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.User;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final UserServiceImpl userServiceImpl;

    public AdminRestController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServiceImpl.getAll());
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userServiceImpl.addUser(user);

        return ResponseEntity.ok(user);
    }

    @PatchMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userServiceImpl.edit(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/removeUser/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Long id) {
        userServiceImpl.delete(id);

        return ResponseEntity.ok(String.format("User with ID = %d was delete!", id));
    }
}
