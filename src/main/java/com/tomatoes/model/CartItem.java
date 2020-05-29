package com.tomatoes.model;

public class CartItem {
	private Products product;
	private int quantity;
	private double totalPrice;
	
	private void CartItem() {}
	
	

	public CartItem(Products product) {
		super();
		this.product = product;
		this.quantity = 1;
		this.totalPrice = product.getProductPrice();
	}



	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
