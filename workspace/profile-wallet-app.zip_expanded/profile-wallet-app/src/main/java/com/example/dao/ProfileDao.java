package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.beans.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer>{

	@Query("select p from Profile p where p.emailId = ?1")
	public Profile getProfile(String emailId);
}
