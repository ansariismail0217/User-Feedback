package com.simplilearn.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	UserFeedbackDAO userFeedbackDAO;
	
	//@GetMapping("/listUsers")
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public List<UserEntity> listUsers() {
		List<UserEntity> list = userFeedbackDAO.getUser();
		return list;
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserEntity entity) {
		if (userFeedbackDAO.addUser(entity)>0) {
			return "Data inserted";
		}
		else {
			return "Error while inserting data";
		}
	}
}
