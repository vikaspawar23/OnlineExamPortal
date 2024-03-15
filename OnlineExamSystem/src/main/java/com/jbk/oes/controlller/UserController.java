package com.jbk.oes.controlller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.jbk.oes.modal.User;
import com.jbk.oes.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController 
{
	@Autowired
	UserService service;
	
	@PostMapping("/saveUser")
	public void saveUser(@RequestBody User user) {
		service.saveUser(user);
	}
	
	
//	@GetMapping("getAllUsers")
//	public List<User> getAllUsers()
//	{
//		return service.getAllUsers();
//	}
//	
//	@RequestMapping("getUser/{username}")
//	public User getUser(@PathVariable String username)
//	{
//		return service.getUser(username);
//	}
//	@DeleteMapping("deleteUser/{username}")
//	public ResponseEntity<Boolean> deleteUser(@PathVariable String username)
//	{
//		service.deleteUser(username);
//		
//		ResponseEntity<Boolean> responseEntity=new ResponseEntity<Boolean>(true,HttpStatus.OK);
//		
//		return responseEntity;
//		
//	}
	
}
