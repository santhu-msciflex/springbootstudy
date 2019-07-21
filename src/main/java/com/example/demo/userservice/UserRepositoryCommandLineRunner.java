package com.example.demo.userservice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	UserRepository service;
	@Override
	public void run(String... args) throws Exception {		
		UserEntity user = new UserEntity("Freddy", new Date());
		service.save(user);
		log.info("User is : {}", user);
	}

}
