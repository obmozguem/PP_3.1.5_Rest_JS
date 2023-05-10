package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;


import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserService;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public String showUserInfo(Model model, Principal principal) {
        model.addAttribute("user", service.findByUsername(
                principal.getName()).get());
        return "userInfo";
    }
}
