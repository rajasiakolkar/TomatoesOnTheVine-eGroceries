package com.tomatoes.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.tomatoes.dao.ProductDAO;
import com.tomatoes.model.Products;

@Controller
public class HomeController {

	
	
	@Autowired
	private ProductDAO prodDAO;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Products> products = prodDAO.getAllProducts();		
		model.addAttribute("products",products);
		return "productList";
		
	}
	
	@RequestMapping("/productList/productDetails/{productId}")
	public String getProductDetails(@PathVariable String productId, Model model) throws IOException {
		Products product = prodDAO.getProductByID(productId);
		model.addAttribute("product",product);
		return "productDetails";
	}
	
	
}
