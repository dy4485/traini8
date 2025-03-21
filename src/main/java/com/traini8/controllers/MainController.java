package com.traini8.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.traini8.dao.UserRepository;
import com.traini8.entity.User;

import jakarta.validation.Valid;

@RestController
public class MainController {
	
	private final UserRepository userRepository;
	
	public MainController(UserRepository userRepository) {
		  this.userRepository = userRepository;
	}
	@PostMapping
	public ResponseEntity<User> createTrainingCenter(@Valid @RequestBody User trainingCenter) {
        User savedCenter = userRepository.save(trainingCenter);
        return ResponseEntity.ok(savedCenter);
    }
	
	 @GetMapping
	 public List<User> getAllTrainingCenters() {
	     return (List<User>) userRepository.findAll(); // Returns an empty list if no records are found
	    }

}
