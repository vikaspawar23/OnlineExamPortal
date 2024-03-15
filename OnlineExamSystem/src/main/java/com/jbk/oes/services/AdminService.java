package com.jbk.oes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.oes.dao.UserDAO;
import com.jbk.oes.modal.User;

@Service
public class AdminService {

	@Autowired
	private UserDAO userDAO;
	
	
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	 
}
