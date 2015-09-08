package com.olyvko.shop.web.controllers;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;







import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olyvko.shop.entity.Order;
import com.olyvko.shop.entity.OrderProduct;
import com.olyvko.shop.entity.Product;
import com.olyvko.shop.entity.ProductCategory;
import com.olyvko.shop.entity.User;
import com.olyvko.shop.service.impl.OrderProductServiceImpl;
import com.olyvko.shop.service.impl.OrderServiceImpl;
import com.olyvko.shop.service.impl.ProductServiceImpl;
import com.olyvko.shop.service.impl.UserServiceImpl;

@Controller
@Scope("request")
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProductServiceImpl productService;

	@Autowired
	private OrderServiceImpl orderService;

	@Autowired
	private OrderProductServiceImpl orderProductService;

	@Autowired
	private UserServiceImpl  userService;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "order";
	}
		
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<Product> getProductsByOrder(HttpSession session) {
		String message ="";
		List<Product> products = null;
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.readField("LOGIN", userName);
		if(user!=null){
			if(session.getAttribute("productIds")!=null){
				Set<Long> idsSet = (Set<Long>) session.getAttribute("productIds");
				List<Long> idProducts = new ArrayList<Long>(idsSet);
				products = productService.readFieldList(idProducts);
			}
		}
		return products;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	ArrayList<String>  addOrders(HttpSession session) {
		ArrayList<String> resMes = new ArrayList<String>();
		Set<Long> idsSet = (Set<Long>) session.getAttribute("productIds");
		String message ="";
		if(idsSet!=null){
		List<Long> idProducts = new ArrayList<Long>(idsSet);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.readField("LOGIN", userName);
			if(user!=null){
					Order orderAdd = new Order();
					orderAdd.setOrderCity("Lviv");
					orderAdd.setOrderDate(new Date(Calendar.getInstance().getTimeInMillis()));
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
					orderAdd.setOrderName("Order - "+dateFormat.format(new Date())+" Lviv");
					orderAdd.setUser(user);
					orderService.create(orderAdd);
					
					for(int i=0;i<idProducts.size();i++){
						Product product = productService.read(idProducts.get(i));
						OrderProduct orderProduct = new OrderProduct();
						orderProduct.setQuantity(1l);
						orderProduct.setPrice(product.getProductPrice());
						orderProduct.setProduct(product);
						orderProduct.setOrder(orderAdd);
						orderProductService.create(orderProduct);
					}
					session.removeAttribute("productIds");
					message = "Order add!";
			}else{
				message = "Error, You must log!";
			}
		}else{
			message = "No products in cart!";
		}
		
		resMes.add(message);
		
		return resMes;
	}
	

	@RequestMapping(value = "", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	List<Order>  getOrders(HttpSession session) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.readField("LOGIN", userName);
		List<Order> order = orderService.readFieldByKey("USER_ID",""+user.getId());
		return order;
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody
	ArrayList<String> createUser(@RequestParam("id") Long id,HttpSession session) {
		ArrayList<String> resMes = new ArrayList<String>();
		Set<Long> productSetIds = new HashSet<Long>();
		if(session.getAttribute("productIds")!=null)
			productSetIds = (Set<Long>) session.getAttribute("productIds");
		productSetIds.add(id);
		session.setAttribute("productIds",productSetIds); 
		resMes.add("Product added to cart");
		return resMes;
	}
	
}
