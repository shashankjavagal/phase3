package com.org.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.sportyshoes.entity.Product;
import com.org.sportyshoes.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/user")
	public String getAllProduct(Model model) {
		model.addAttribute("products",productService.displayAllProduct());
		return "user-dashboard";
	}
	
	
	
	@GetMapping("/admin/addproduct")
	public String addProduct() {
		return "new-product";
	}
	
	
	@PostMapping("/admin/newproduct")
	public String productAdd(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/admin/";
	}
	
	@RequestMapping(value = "/admin/delete-product/{id}")
    private String deleteProduct(@PathVariable("id") int id)
    {
	  productService.delete(id);
	  return "redirect:/admin/";
    }
	
	
	
	
	

}
