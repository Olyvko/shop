package com.olyvko.shop.web.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.olyvko.shop.entity.User;
import com.olyvko.shop.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private UserServiceImpl userService;
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String adminUserPage() {
		return "admin/user";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<User> getUsers() {
		List<User> users = userService.readAll();
		return users;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	User createUser(@RequestParam("id") Long id,@RequestParam("status") Boolean status) {
		User user =	userService.read(id);
		user.setActive(new Boolean(status));
		userService.update(user);
		return user;
	}
}

