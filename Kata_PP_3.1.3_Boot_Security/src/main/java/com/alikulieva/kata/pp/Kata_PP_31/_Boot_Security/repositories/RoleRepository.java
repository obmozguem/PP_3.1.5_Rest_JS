package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.repositories;


import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
