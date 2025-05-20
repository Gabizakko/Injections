package com.example.injections.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/search")
    public List<?> searchUser(@RequestParam String username) {
        // ⚠️ SQL Injection kwetsbaar: gebruikersinvoer direct in query
        String sql = "SELECT * FROM app_user WHERE username = '" + username + "'";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }

}
