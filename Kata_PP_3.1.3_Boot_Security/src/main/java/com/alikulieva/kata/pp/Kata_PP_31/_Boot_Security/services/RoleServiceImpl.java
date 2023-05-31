package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services;

import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.Role;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
