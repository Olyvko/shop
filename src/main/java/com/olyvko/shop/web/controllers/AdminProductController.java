package com.olyvko.shop.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.service.impl.ProductCategoryServiceImpl;
import com.olyvko.shop.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private ProductCategoryServiceImpl pCategoryServise;
	
	@RequestMapping(value = "/by/category/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<Product> getProductsByCategory(@PathVariable("id") Long id) {
		List<Product> productByCategory = productService.readFieldByKey("PRODUCT_CATEGORY_ID", ""+id);
		return productByCategory;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<Product> deleteProduct(@PathVariable("id") Long id) {
		productService.delete(id);
		List<Product> product = productService.readAll();
		return product;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	Product createCategory(@RequestParam Map<String, String>  ParamVars) {
		Product product = new Product();
		product.setProductName(ParamVars.get("productName"));
		product.setProductPrice(Long.parseLong(ParamVars.get("productPrice")));
		product.setProductImage(ParamVars.get("productImage"));
		product.setProductDescription(ParamVars.get("productDescription"));
		product.setProductCategory(pCategoryServise.read(Long.parseLong(ParamVars.get("productCategory"))));
		product.setData(new byte[1]);
		productService.create(product);
		return product;
	}
	
	@Autowired
	ServletContext servletContext;
	@RequestMapping(value = "/image/create", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	ArrayList<String>  createImage(MultipartHttpServletRequest request, HttpServletResponse response) {
		Iterator<String> itr =  request.getFileNames();
		 
	     MultipartFile mpf = request.getFile(itr.next());
		 ArrayList<String> resMes = new ArrayList<String>();
	     try {
	    	 String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), "png");
	    	
	    	 String path = servletContext.getContextPath()+"/src/main/webapp/resources/images/data/"+name;
	    	// String path = name;
	    	 File serverFile = new File(path);
	         BufferedOutputStream stream = new BufferedOutputStream(
	                 new FileOutputStream(serverFile));
	         stream.write(mpf.getBytes());
	         stream.close();
	         
	         resMes.add(name);
	       //  resMes.add("no_image.png");
	        // resMes.add(serverFile.getAbsolutePath());
	        // resMes.add(System.getenv("OPENSHIFT_DATA_DIR"));
	       //  resMes.add(servletContext.getContextPath());
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return resMes;
	}
	
	@ResponseBody 
	@RequestMapping(value = "/im")
	public byte[] testphoto() throws IOException {
		System.out.println(123);
	    InputStream in = servletContext.getResourceAsStream("/resources/images/image/data/logo_admin.png");
	    return IOUtils.toByteArray(in);
	}

	@ResponseBody 
	@RequestMapping(value = "/ima",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] testphotoa() throws IOException {
	    InputStream in = servletContext.getResourceAsStream("/shop/resources/images/image/data/logo_admin.png");
	    return IOUtils.toByteArray(in);
	}

	@ResponseBody 
	@RequestMapping(value = "/imag",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] testphotoag() throws IOException {
	    InputStream in = servletContext.getResourceAsStream("/src/main/webapp/resources/images/image/data/logo_admin.png");
	    return IOUtils.toByteArray(in);
	}

	@ResponseBody 
	@RequestMapping(value = "/image",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] testphotoage() throws IOException {
	    InputStream in = servletContext.getResourceAsStream("/shop/src/main/webapp/resources/images/image/data/logo_admin.png");
	    return IOUtils.toByteArray(in);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	Product getCategory(@PathVariable("id") Long id) {
		Product product = productService.read(id);
		return product;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	Product updateCategory(@RequestParam Map<String, String>  ParamVars) {
		Product product = new Product();
		product.setId(Long.parseLong(ParamVars.get("id")));
		product.setProductName(ParamVars.get("productName"));
		product.setProductPrice(Long.parseLong(ParamVars.get("productPrice")));
		product.setProductImage(ParamVars.get("productImage"));
		product.setProductDescription(ParamVars.get("productDescription"));
		product.setProductCategory(pCategoryServise.read(Long.parseLong(ParamVars.get("productCategory"))));
		product.setData(new byte[1]);
		productService.update(product);
		return product;
	}

}
