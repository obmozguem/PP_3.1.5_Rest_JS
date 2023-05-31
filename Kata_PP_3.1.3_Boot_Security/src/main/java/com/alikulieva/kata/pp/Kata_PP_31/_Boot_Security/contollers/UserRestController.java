package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;


import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.User;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserServiceImpl userServiceImp;

    public UserRestController(UserServiceImpl userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(userServiceImp.getById(id));
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }
}

