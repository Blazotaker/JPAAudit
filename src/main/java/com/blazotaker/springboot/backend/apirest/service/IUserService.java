package com.blazotaker.springboot.backend.apirest.service;

import java.util.List;

import com.blazotaker.springboot.backend.apirest.exception.ResourceNotFoundException;
import com.blazotaker.springboot.backend.apirest.model.User;

public interface IUserService{
	
	public List<User> findAll();
	
	public User findById(Long id) throws ResourceNotFoundException;
	
	public User save(User user);
	
	public void deletedById(Long id);
  
}
