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
public class AdminController {


	private Path path;
	
	@Autowired
	private ProductDAO prodDAO;
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/admin/inventory")
	public String inventory(Model model) {
		List<Products> products = prodDAO.getAllProducts();
		model.addAttribute("products",products);
		return "inventory";	
	}
	
	@RequestMapping(value="/admin/inventory/addProduct")
	public String addProduct(Model model) {
		Products product = new Products();
	
		model.addAttribute("products",product);
		return "addProduct";
	}
	
	@RequestMapping(value="/admin/inventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("products")Products product,BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		
		prodDAO.addProduct(product);
		MultipartFile image = product.getImage();
		String rootDir= request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + product.getProductId()+".png");
		
		if(image !=null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
			} 
			catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to save the image",e);
				
			}
		}
		return "redirect:/admin/inventory";
		
	}
	
	@RequestMapping("/admin/inventory/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable String productId, Model model) throws IOException {
		
		prodDAO.deleteProduct(productId);
		return "redirect:/admin/inventory";
	}
	
	@RequestMapping(value="/admin/inventory/editProduct/{productId}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("productId") String productId, Model model) {
		
		Products product = prodDAO.getProductByID(productId);
		model.addAttribute(product);
		
		return "editProduct";
	}
	
	@RequestMapping(value="/admin/inventory/editProduct", method=RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("products")Products product,BindingResult result, Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "editProduct";
		}
		
		MultipartFile image = product.getImage();
		String rootDir= request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + product.getProductId()+".png");
		
		if(image !=null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
			} 
			catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to save the image",e);
				
			}
		}
		
		prodDAO.editProduct(product);
		return "redirect:/admin/inventory";
	}
}
