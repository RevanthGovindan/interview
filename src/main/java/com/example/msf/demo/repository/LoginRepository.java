package com.example.msf.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.msf.demo.model.Login;

public interface LoginRepository extends MongoRepository<Login,String>{
	public Login findOneByName(String name);
}
