package com.tomatoes.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String productId;
	
	@NotEmpty(message="Please enter the product name!")
	private String productName;
	private String productCategory;
	private String productDescription;
	
	@Min(value=1, message="The price cannot be less than $1")
	private double productPrice;
	private String productStatus;
	
	@Min(value=10, message="The minimum quantity must be 10")
	private int productnumAvailable;
	
	
	@Transient 
	private MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getProductnumAvailable() {
		return productnumAvailable;
	}
	public void setProductnumAvailable(int productnumAvailable) {
		this.productnumAvailable = productnumAvailable;
	}
	
	
}
