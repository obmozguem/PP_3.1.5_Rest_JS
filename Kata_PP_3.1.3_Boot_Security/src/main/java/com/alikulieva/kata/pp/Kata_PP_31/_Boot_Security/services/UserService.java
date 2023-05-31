package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services;

import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getById(Long id);
    void addUser(User user);

    void edit(User user);

    List<User> getAll();

    void delete(Long id);

    Optional<User> findByUsername(String username);
}
