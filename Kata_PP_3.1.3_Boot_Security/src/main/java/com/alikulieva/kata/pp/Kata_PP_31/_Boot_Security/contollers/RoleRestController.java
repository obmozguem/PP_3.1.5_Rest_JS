package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.contollers;

import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.Role;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/roles")
public class RoleRestController {
    private final RoleService roleService;
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}
