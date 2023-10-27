package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Profile;
import com.example.exceptions.ProfileNotFoundException;
import com.example.service.ContactService;
import com.example.service.ProfileService;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/profile")
@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> store(@RequestBody Profile profile) {
		Profile p = profileService.createProfile(profile);
		return ResponseEntity.status(200).body(p);
	}
	@GetMapping(path = "/{emailId}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@PathVariable("emailId") String emailId,@PathVariable("password")  String password) {
		try {
			return ResponseEntity.status(200).body(profileService.login(emailId, password));
		} catch(ProfileNotFoundException e) {
			Map<String, String> map = new HashMap<>();
			map.put("error", e.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	@GetMapping(path = "/{emailId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fetch(@PathVariable("emailId") String emailId) {
			return ResponseEntity.status(200).body(profileService.getProfile(emailId));
	}
	
	@GetMapping(path = "/queryProfile/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fetch(@PathVariable("profileId") int profileId) {
			return ResponseEntity.status(200).body(contactService.getAllContacts(profileId));
	}
}
