package com.example.service;

import java.util.List;

import com.example.beans.Contact;
import com.example.beans.Profile;
import com.example.exceptions.ProfileNotFoundException;

public interface ProfileService {
	
	public Profile createProfile(Profile profile);
	public Profile getProfile(String emailId);
	public Profile login(String emailId, String password) throws ProfileNotFoundException;
	public List<Contact> addContact(int profileIdRef, int walletIdRef);
}
