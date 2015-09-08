package com.olyvko.shop.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.entity.User;
import com.olyvko.shop.service.impl.UserServiceImpl;



@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserServiceImpl  userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView();
		if (error != null)
			model.addObject("error", "Invalid username and password!");
		return model;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	User getProductsByOrder() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.readField("LOGIN", userName);
		return user;
	}
	
}
