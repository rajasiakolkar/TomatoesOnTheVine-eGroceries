package com.tomatoes.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tomatoes.dao.CartDAO;
import com.tomatoes.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO{

	private Map<String,Cart> cartList;
	
	public CartDAOImpl() {
		cartList = new HashMap<String, Cart>();
	}
	
	@Override
	public Cart create(Cart cart) {
		if(cartList.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Cart already exists!",cart.getCartId()));
		}
		
		cartList.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return cartList.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!cartList.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Cart does not exist!",cart.getCartId()));
		}
		cartList.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if(!cartList.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("Cart does not exist!",cartId));
		}
		cartList.remove(cartId);
		
	}

}
