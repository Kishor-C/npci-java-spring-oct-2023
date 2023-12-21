package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.UserBean; 


public interface UserBeanRepository extends JpaRepository<UserBean, Integer> { 
	// finds the user using name property 
	Optional<UserBean> findByName(String name); 
}

