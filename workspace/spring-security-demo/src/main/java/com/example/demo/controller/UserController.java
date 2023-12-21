package com.example.demo.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthRequest;
import com.example.demo.entity.UserBean;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserDetailServiceImpl;

import jakarta.servlet.http.HttpServletRequest; 

@RestController
@RequestMapping("/auth") 
public class UserController { 

	// UserDetailsService to loadUserByName, addUser
	@Autowired
	private UserDetailServiceImpl service; 

	// JwtService takes care of generating token based on the authentication request
	@Autowired
	private JwtService jwtService; 

	@Autowired
	private AuthenticationManager authenticationManager; 

	@GetMapping("/welcome") 
	public String welcome() { 
		return "Welcome this endpoint is not secure"; 
	} 

	@PostMapping("/addNewUser") 
	public String addNewUser(@RequestBody UserBean userInfo) { 
		return service.addUser(userInfo); 
	} 

	@GetMapping("/user/userProfile") 
	// internally token is verified using spring security authorization process
	@PreAuthorize("hasAuthority('ROLE_USER')") 
	public ResponseEntity<Object> userProfile(HttpServletRequest request) { 
		String name = (String)request.getAttribute("key");
		Map<String, Object> map = new HashMap<>();
		UserDetails userDetails = service.loadUserByUsername(name);
		map.put("userDetails", userDetails);
		map.put("authorities", userDetails.getAuthorities());
		return ResponseEntity.status(200).body(map); 
	} 

	@GetMapping("/admin/adminProfile") 
	// internally token is verified using spring security authorization process
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	public ResponseEntity<Object> adminProfile(HttpServletRequest request) { 
		String name = (String)request.getAttribute("key");
		Map<String, Object> map = new HashMap<>();
		UserDetails userDetails = service.loadUserByUsername(name);
		map.put("userDetails", userDetails);
		map.put("authorities", userDetails.getAuthorities());
		return ResponseEntity.status(200).body(map);  
	} 

	@PostMapping("/generateToken") 
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
		// authentication object for username and password
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
		if (authentication.isAuthenticated()) { 
			// generate token 
			return jwtService.generateToken(authRequest.getUsername()); 
		} else { 
			throw new UsernameNotFoundException("invalid user request !"); 
		} 
	} 

} 

