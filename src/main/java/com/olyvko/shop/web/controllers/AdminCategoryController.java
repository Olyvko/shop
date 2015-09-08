package com.olyvko.shop.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.service.impl.ProductCategoryServiceImpl;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

	@Autowired
	private ProductCategoryServiceImpl pCategoryService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String adminPage() {
		return "admin/category";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<ProductCategory> getCategories() {
			List<ProductCategory> pCategories = pCategoryService.readAll();
		return pCategories;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	ProductCategory getCategory(@PathVariable("id") Long id) {
			ProductCategory pCategory = pCategoryService.read(id);
		return pCategory;
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<ProductCategory> deleteCategory(@PathVariable("id") Long id) {
			pCategoryService.delete(id);
			List<ProductCategory> pCategories = pCategoryService.readAll();
		return pCategories;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	ProductCategory createCategory(@ModelAttribute("productCategory") ProductCategory productCategory) {
			pCategoryService.create(productCategory);
		return productCategory;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	ProductCategory updateCategory(@ModelAttribute("productCategory") ProductCategory productCategory) {
			pCategoryService.update(productCategory);
		return productCategory;
	}

}
