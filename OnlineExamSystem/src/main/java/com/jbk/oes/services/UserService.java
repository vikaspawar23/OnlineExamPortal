package com.jbk.oes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.oes.dao.UserDAO;
import com.jbk.oes.modal.User;

@Service
public class UserService 
{
	@Autowired
	UserDAO dao;
	
	public void saveUser(User user) {
		dao.saveUser(user);
	}
	
	public List<User> getAllUsers()
	{
		return dao.getAllUsers();
	}
	
	
	public User getUser(String username)
	{
		return dao.getUser(username);
	}
	
	public void deleteUser(String username)
	{
		dao.deleteUser(username);
	}
	
}
