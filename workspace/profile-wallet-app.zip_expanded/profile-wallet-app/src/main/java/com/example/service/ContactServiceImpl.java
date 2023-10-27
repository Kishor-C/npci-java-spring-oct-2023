package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Profile;
import com.example.beans.dto.QueryProfile;
import com.example.dao.ProfileDao;

@Service  
public class ContactServiceImpl implements ContactService {

	
	
	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public List<QueryProfile> getAllContacts(int profileId) {
		
		List<Profile> profilesList = profileDao.findAll();
		List<Profile> allProfileExceptOne = profilesList.stream()
				.filter(item->item.getProfileId() != profileId).toList();
		return allProfileExceptOne.stream()
		.map(item -> new QueryProfile(item.getProfileId(), item.getName(), item.getWalletIdRef().getWalletId()))
		.toList();
		
	}

}
