package com.olyvko.shop.web.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.entity.User;
import com.olyvko.shop.service.impl.ProductCategoryServiceImpl;
import com.olyvko.shop.service.impl.ProductServiceImpl;
import com.olyvko.shop.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ProductCategoryServiceImpl pCategoryService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<ProductCategory> getCategories() {
		List<ProductCategory> pCategories = pCategoryService.readAll();
		return pCategories;
	}
}
