package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.services;

import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.Role;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.User;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.repositories.RoleRepository;
import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.repositories.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void addUser(User newUser) {
        newUser.setUsername(newUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        userRepository.save(newUser);
    }

    @Override
    public void edit(User updatedUser) {
        User user = this.getById(updatedUser.getId());

        updatedUser.setUsername(updatedUser.getEmail());
        if (!updatedUser.getPassword().equals(user.getPassword())) {
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        userRepository.save(updatedUser);
    }
    @Query("Select u from User u left join fetch u.roles")
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);

    }
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User %s doesn't exists", username)));
        return user;
    }
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
