package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/login")
    public String loginPage (@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout, Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);

        return "login";
    }
    @GetMapping (value = "/")
    public String printWelcome () {
        return "index";
    }

}