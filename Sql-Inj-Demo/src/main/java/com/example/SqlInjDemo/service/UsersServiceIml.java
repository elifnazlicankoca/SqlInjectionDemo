package com.example.SqlInjDemo.service;


import com.example.SqlInjDemo.model.Users;
import com.example.SqlInjDemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UsersServiceIml implements UsersService{

    @Autowired
    UsersRepository usersRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Users> findByUsersDetails(String email){

        return usersRepository.findAllUsersByEmail(email);
    }

    public List<Users> findByUsersNativeDetails(String email){

        return usersRepository.findAllEmployeeByEmpNameNative(email);
    }

    public List<Users> findByEmailSql(String email, String password){

        Query query=entityManager.createNativeQuery("SELECT * FROM USERS WHERE EMAIL =  :email and Password=:password ",Users.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return query.getResultList();
    }
    public List<Users> findByEmailSqlWithInjection(String email, String password){

        //sql injection attack
        Query query=entityManager.createNativeQuery("SELECT * FROM USERS WHERE EMAIL ='"+email+"' and PASSWORD= '"+password+"'", Users.class);

        return query.getResultList();
    }

}
