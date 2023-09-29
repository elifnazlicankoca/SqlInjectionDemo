package com.example.SqlInjDemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    private int Id;

    private String email;

    private String password;

}
