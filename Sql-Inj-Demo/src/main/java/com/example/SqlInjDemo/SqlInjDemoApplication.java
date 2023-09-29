package com.example.SqlInjDemo;


import com.example.SqlInjDemo.model.Users;
import com.example.SqlInjDemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.SqlInjDemo.model"})
@EnableJpaRepositories(basePackages="com.example.SqlInjDemo.repository")
public class SqlInjDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlInjDemoApplication.class, args);
	}

	@Autowired
	UsersRepository usersRepository;

	@PostConstruct
	public void initUsersDetails(){

		List<Users> usersList =new ArrayList<>();
		usersList.add(new Users(1,"ali@ali.com","123"));
		usersList.add(new Users(2,"ayse@ayse.com","123"));
		usersList.add(new Users(3,"ela@ela.com","123"));
		usersList.add(new Users(4,"pinar@pinar.com","123"));
		usersList.add(new Users(5,"elif@elif.com","123"));

		usersRepository.saveAll(usersList);
	}
}