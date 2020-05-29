package com.tomatoes.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String cartId;
	private Map<String,CartItem> cartItems;
	private double finalTotal;
	
	private Cart() {
		cartItems = new HashMap<String,CartItem>();
		finalTotal=0;
	}
	
	public Cart(String cartId) {
		this();
		this.cartId=cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}
	
	public void addCartItem(CartItem item) {
		String productId = item.getProduct().getProductId();
		
		if(cartItems.containsKey(productId)) {
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
			cartItems.put(productId,existingCartItem);
		} 
		else
		{
			cartItems.put(productId, item);
		}
		
		updateFinalTotal();
	}
	
	public void removeCartItem(CartItem item) {
		String productId = item.getProduct().getProductId();
		cartItems.remove(productId);
		updateFinalTotal();
	}
	
	public void updateFinalTotal() {
		finalTotal=0;
		for(CartItem item:cartItems.values()) {
			finalTotal = finalTotal + item.getTotalPrice();
		}
	}
	
	
	
	
}
