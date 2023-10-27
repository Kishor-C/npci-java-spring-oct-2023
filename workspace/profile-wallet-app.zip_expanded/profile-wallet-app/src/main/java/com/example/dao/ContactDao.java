package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.beans.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {

	@Query("select c from Contact c where c.profileIdRef = ?1")
	List<Contact> getContacts(int profileId);
}
