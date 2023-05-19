package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;


import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.User;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserService;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl service;

    public AdminController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public String getAdminPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("allRoles", service.getAllRoles());
        model.addAttribute("users", service.getAll());
        return "admin";
    }


    @PostMapping("/createNewUser")
    public String createUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/admin";
    }


    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        service.edit(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        service.delete(id);
        return "redirect:/admin";
    }
}
