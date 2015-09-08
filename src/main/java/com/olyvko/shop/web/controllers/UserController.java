package com.olyvko.shop.web.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.entity.Role;
import com.olyvko.shop.entity.User;
import com.olyvko.shop.service.UserService;
import com.olyvko.shop.service.impl.ProductCategoryServiceImpl;
import com.olyvko.shop.service.impl.ProductServiceImpl;
import com.olyvko.shop.service.impl.UserServiceImpl;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl  userService;

	@Autowired
	private ProductCategoryServiceImpl pCategoryService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	User createUser(@ModelAttribute("user") User user) {
		userService.create(user);
		return user;
	}
	
	
	@RequestMapping(value = "/asd", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<ProductCategory> getCategories() {
		List<ProductCategory> pCategories = pCategoryService.readAll();
		return pCategories;
	}
}
