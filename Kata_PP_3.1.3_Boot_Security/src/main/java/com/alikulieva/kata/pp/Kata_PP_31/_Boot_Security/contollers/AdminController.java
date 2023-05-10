package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;


import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.User;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserService;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService service;

    @Autowired
    public AdminController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public String show(Model model) {
        model.addAttribute("users", service.getAll());
        return "/allUsers";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "add";
        }
        service.addUser(user);
        return "redirect:/admin/getAll";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam(value = "id") Long id) {
        model.addAttribute("user", service.getById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        service.edit(user);
        return "redirect:/admin/getAll";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        service.delete(id);
        return "redirect:/admin/getAll";
    }

}
