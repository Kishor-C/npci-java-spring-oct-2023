package com.npci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.service.AdminServiceImpl;

@RestController
@RequestMapping("/api2")
public class AdminController {

	@Autowired
	private AdminServiceImpl service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<String> finder(@PathVariable("id") int id) {
		String result = service.findingEmployee(id);
		return ResponseEntity.status(200).body(result);
	}
}
