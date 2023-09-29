package com.example.SqlInjDemo.repository;

import com.example.SqlInjDemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("select e from Users as e where e.email = :email")
    List<Users> findAllUsersByEmail(@Param("email") String email);

    @Query(value = "select * from Users where email = :email", nativeQuery = true) //NativeQuery
    List<Users> findAllEmployeeByEmpNameNative(@Param("email") String  email);

}
