package com.blazotaker.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blazotaker.springboot.backend.apirest.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long>{
	
}
