package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring Security application");
        messages.add("3.0.6 version by may'23 ");
        model.addAttribute("messages", messages);
        return "index";
    }
}