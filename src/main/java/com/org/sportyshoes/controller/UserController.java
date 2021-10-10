package com.org.sportyshoes.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.sportyshoes.entity.Order;
import com.org.sportyshoes.entity.Product;
import com.org.sportyshoes.entity.User;
import com.org.sportyshoes.service.OrderService;
import com.org.sportyshoes.service.ProductService;
import com.org.sportyshoes.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/login")
	public String adminLogin() {
		return "user-login";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		 System.out.println(principal.getName());
	     return principal.getName();
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register-user";	
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User user) {
		user.setRole("USER");
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		userService.registerCustomer(user);
		return "redirect:/";
	}
	
	@GetMapping("/admin/changepassword")
	public String changeAdminPassword() {
		return "update-admin-password";	
	}
	
	@PostMapping("/admin/updatepassword")
	public String updateAdminPassword(Principal principle,@ModelAttribute("user") User user) {
		User userOne=userService.getUserByUserName(principle.getName());
		System.out.println("password"+user.getPassword());
		userOne.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		userService.registerCustomer(userOne);
		return "redirect:/admin/";
	}
		
	@GetMapping("/admin/")
	public String getAllProduct(Model model) {
		model.addAttribute("products",productService.displayAllProduct());
		return "admin-dashboard";
	}
	
	@GetMapping("/admin/alluser")
	public String getAllUser(Model model,@Param("username") String username) {
		List<User> result=new ArrayList<User>();
		result.add(userService.getUserByUserName(username));
		System.out.println(userService.getUserByUserName(username));
		if(username!=null) {
			model.addAttribute("users",result);
			if(userService.getUserByUserName(username)==null) {
				model.addAttribute("message","No User Found");
			}
		}
		else {
			model.addAttribute("users",userService.displayAllCustomer());
		}
		return "user-details";
	}
	
	@GetMapping(value = "/purchase-product/{id}")
    private String purchaseProduct(@PathVariable("id") int id,Principal principle)
    {
	  Product product=productService.findProductById(id);
	  User user=userService.getUserByUserName(principle.getName());
	  Order order=new Order();
	  LocalDate date=LocalDate.now();
	  String todayDate=""+date;
	  order.setDate(todayDate);
	  order.setProduct(product);
	  order.setUser(user);
	  orderService.orderProduct(order);
	  System.out.println("order page");
	  return "purchase-sucessfully";
    }
	
	@GetMapping("/admin/receivedOrder")
	public String getAllOrderHistory(Model model,@Param("category") String category,@Param("date") String date) {
		
		if(category!=null&&date!=null) {
			model.addAttribute("orders",orderService.filterOrderHistoryByCategoryAndDate(category, date));
			List<Order> list=orderService.filterOrderHistoryByCategoryAndDate(category, date);
			if(list.size()==0) {
				model.addAttribute("message","No order Found");
			}
		}else {
		model.addAttribute("orders",orderService.purchaseHistory());
		}
		
		return "purchase-history";
	}
	
	
	
	
}
