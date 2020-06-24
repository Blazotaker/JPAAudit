package com.blazotaker.springboot.backend.apirest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blazotaker.springboot.backend.apirest.dao.IUserDao;
import com.blazotaker.springboot.backend.apirest.exception.ResourceNotFoundException;
import com.blazotaker.springboot.backend.apirest.model.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) throws ResourceNotFoundException  {
		return userDao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado en :: "+ id));
	}

	@Override
	@Transactional
	public User save(User user) {
		return userDao.save(user);
	}

	
	
	@Override
	@Transactional
	public void deletedById(Long id) {
		userDao.deleteById(id);		
	}

	

}
