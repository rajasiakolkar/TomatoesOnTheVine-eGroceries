package com.tomatoes.dao;

import com.tomatoes.model.Cart;

public interface CartDAO {
	Cart create(Cart cart);
	Cart read(String cartId);
	void update(String cartId,Cart cart);
	void delete(String cartId);

}
