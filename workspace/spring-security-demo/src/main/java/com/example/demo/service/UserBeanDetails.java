package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.UserBean; 

// provides core user details with getter methods for name, password, authorities
public class UserBeanDetails implements UserDetails { 

	private String name; 
	private String password; 
	private List<GrantedAuthority> authorities; 

	// initialize the UserDetails 
	public UserBeanDetails(UserBean userBean) { 
		name = userBean.getName(); 
		password = userBean.getPassword(); 
		authorities = Arrays.stream(userBean.getRoles().split(",")) 
				.map((roles) -> new SimpleGrantedAuthority(roles)) 
				.collect(Collectors.toList()); 
	} 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return authorities; 
	} 

	@Override
	public String getPassword() { 
		return password; 
	} 

	@Override
	public String getUsername() { 
		return name; 
	} 

	@Override
	public boolean isAccountNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isAccountNonLocked() { 
		return true; 
	} 

	@Override
	public boolean isCredentialsNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isEnabled() { 
		return true; 
	} 
} 

