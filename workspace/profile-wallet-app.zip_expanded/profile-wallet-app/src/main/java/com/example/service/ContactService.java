package com.example.service;

import java.util.List;

import com.example.beans.dto.QueryProfile;

public interface ContactService {
	public List<QueryProfile> getAllContacts(int profileId);
}
