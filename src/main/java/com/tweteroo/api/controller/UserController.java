package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.User;
import com.tweteroo.api.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> listAll() {
        return service.findAll();
    }

    @PostMapping("/sign-up")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody UserDTO req) {
        User user = service.createUser(req);
        if(user != null){
            return "OK";
        } else {
            return "Error!";
        }
    }
}
