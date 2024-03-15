package com.jbk.oes.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.oes.modal.User;
import com.jbk.oes.services.AdminService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController 
{
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return adminService.getAllUsers();
	}
	
}
