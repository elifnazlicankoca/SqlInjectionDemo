package com.example.SqlInjDemo.controller;


import com.example.SqlInjDemo.model.Input;
import com.example.SqlInjDemo.model.Users;
import com.example.SqlInjDemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sqlInjection")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/jpa")
    public List<Users> findByUsersDetails(@RequestBody Input input){
        return usersService.findByUsersDetails(input.getEmail());
    }

    @PostMapping("/jpa/sql")
    public List<Users> findByNativeEmpDetails(@RequestBody Input input){
        return usersService.findByUsersNativeDetails(input.getEmail());
    }

    @PostMapping("/sql")
    public List<Users> findByNativeEmployee(@RequestBody Input input){
        return usersService.findByEmailSql(input.getEmail(),input.getPassword());
    }

    @PostMapping("/sql/inj")
    public List<Users> findByWithInjection(@RequestBody Input input){
        return usersService.findByEmailSqlWithInjection(input.getEmail(),input.getPassword());
    }
}
