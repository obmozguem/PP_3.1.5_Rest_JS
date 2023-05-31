package com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.repositories;


import com.alikulieva.kata.pp.Kata_PP_31._Boot_Security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u left join fetch u.roles where u.username=:username")
    //в строке ниже было исправление
    Optional<User> findByUsername(@Param("username")String username);
}