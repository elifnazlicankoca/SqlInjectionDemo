package com.example.SqlInjDemo.service;


import com.example.SqlInjDemo.model.Users;

import java.util.List;


public interface UsersService {
    public List<Users> findByUsersDetails(String email);
    public List<Users> findByUsersNativeDetails(String email);
    public List<Users> findByEmailSql(String email, String password);
    public List<Users> findByEmailSqlWithInjection(String email, String password);


}
