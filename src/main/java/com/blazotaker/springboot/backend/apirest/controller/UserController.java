package com.blazotaker.springboot.backend.apirest.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blazotaker.springboot.backend.apirest.exception.ResourceNotFoundException;
import com.blazotaker.springboot.backend.apirest.model.User;
import com.blazotaker.springboot.backend.apirest.service.IUserService;

@CrossOrigin(origins  = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/users")
	public List<User> index(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User show(@PathVariable Long id) throws ResourceNotFoundException {
		return userService.findById(id);
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> update
	(@PathVariable Long id ,@RequestBody User user) throws ResourceNotFoundException {
		User userFound = userService.findById(id);
		user.setEmail(userFound.getEmail());
		user.setFirstName(userFound.getFirstName());
		user.setLastName(userFound.getLastName());
		user.setUpdatedAt(new Date());
		final User updatedUser = userService.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	 @DeleteMapping("/user/{id}")
	   public Map<String, Boolean> deleteUser(
	       @PathVariable Long id) throws Exception {
	       User user = userService.findById(id);
	         

	       userService.deletedById(id);
	       Map<String, Boolean> response = new HashMap<>();
	       response.put("deleted", Boolean.TRUE);
	       return response;
	   }
	
	
	

}
