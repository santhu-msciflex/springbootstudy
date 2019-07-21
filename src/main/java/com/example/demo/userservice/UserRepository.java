package com.example.demo.userservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{	

}
