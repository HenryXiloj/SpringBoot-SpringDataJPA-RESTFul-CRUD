package com.hxiloj.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hxiloj.model.User;
import com.hxiloj.test.dao.UserRepository;

/**
 * @author Henry
 *
 */

@RestController
@RequestMapping("/ws")
public class TestController {

	 @Autowired
	 UserRepository userRepository;
	 
	 @RequestMapping("/create")
	 public User create(User user) {
		 
	  user.setName("Henry");
	  user.setEmail("abc@gmail.com");
	  user.setAge(31);
	
	  user = userRepository.save(user);
	  return user;
	 }
	 
	 @GetMapping("/read")
	 public List<User> read() {
		 List<User> user = userRepository.findAll();
		 return user;
	 }
	 
	 
	 @RequestMapping("/update")
	 public User update(@RequestParam Integer userID) {
		
		 Optional<User> user = userRepository.findById(userID);
		 user.get().setName("henry1");
		 User obj  = userRepository.save(user.get());
	     return obj;
	 }
	 
	 
	 @RequestMapping("/delete")
	 public String delete(@RequestParam Integer userID) {
		 
		 User user = new User();
		 user.setId(userID);
		 
		 userRepository.delete(user);
	     return "user "+userID+" deleted successfully";
	 }
	 
}
