package com.tomatoes.dao;
import java.util.List;

import com.tomatoes.model.Products;

public interface ProductDAO {

	void addProduct(Products product);
	
	Products getProductByID(String productId);
	
	List<Products> getAllProducts();
	
	void deleteProduct(String productId);
	
	void editProduct(Products product);
}
