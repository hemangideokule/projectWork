package com.Dao;

import com.model.Cart;

public interface CartDao {
	public void insertCart(Cart cart);
	  public void deleteCart(int cartId);
	    public void updateCart(Cart cr);
}
