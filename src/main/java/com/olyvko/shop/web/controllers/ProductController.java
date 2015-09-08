package com.olyvko.shop.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@RequestMapping(value = "/by/category/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<Product> getProductsByCategory(@PathVariable("id") Long id) {
		List<Product> productByCategory = productService.readFieldByKey("PRODUCT_CATEGORY_ID", ""+id);
		return productByCategory;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	Product getProduct(@PathVariable("id") Long id) {
		Product product = productService.read(id);
		return product;
	}
}
