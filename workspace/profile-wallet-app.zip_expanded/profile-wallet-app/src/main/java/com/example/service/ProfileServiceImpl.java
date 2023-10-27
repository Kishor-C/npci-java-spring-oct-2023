package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.beans.Account;
import com.example.beans.Contact;
import com.example.beans.Profile;
import com.example.beans.Wallet;
import com.example.dao.ContactDao;
import com.example.dao.ProfileDao;
import com.example.exceptions.ProfileNotFoundException;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private ContactDao contactDao;
	
	@Override
	@Transactional
	public Profile createProfile(Profile profile) {
		Wallet wallet = new Wallet();
		wallet.setAmount(500);
		Account account = new Account();
		account.setBalance(6000);
		wallet.setAccountNumberRef(account);
		profile.setWalletIdRef(wallet);
		return profileDao.save(profile);
	}

	@Override
	public Profile login(String emailId, String password) throws ProfileNotFoundException {
		Profile profile = profileDao.getProfile(emailId);
		if(profile.getPassword().equals(password)) {
			List<Contact> contact = contactDao.getContacts(profile.getProfileId());
			profile.setContacts(contact);
			return profile;
		}
		throw new ProfileNotFoundException("Profile not found with an email-id "+emailId);
	}

	@Override
	public List<Contact> addContact(int profileIdRef, int walletIdRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile getProfile(String emailId) {
		Profile profile = profileDao.getProfile(emailId);
		List<Contact> contact = contactDao.getContacts(profile.getProfileId());
		profile.setContacts(contact);
		return profile;
		
	}

}
